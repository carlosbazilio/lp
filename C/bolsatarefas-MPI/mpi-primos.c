/* Disciplina: Computacao Concorrente */
/* Prof.: Silvana Rossetto */
/* Usar o modelo 'bolsa de tarefas' para encontrar os numeros primos em um intervalo 
   de valores dado, usando N processos e troca de mensagens com o MPI */
/* --------------------------------------------------------------------------------------*/

#include <mpi.h>
#include <stdio.h>
#include <math.h>

#define TASKTAG 200    //tag de pedido de tarefa
#define RESULTAG 300   //tag de envio de resultado
#define DIETAG 400     //tag de termino da aplicacao
#define N 10000 //intervalo de numeros para encontrar os primos 0--N (!!nao deve incluir os numeros usados para as tags acima!!)

//funcoes locais
static void mestre(void);
static void escravo(int id);
int ehPrimo (int n);
void trataResultado (long resultado[]);

unsigned long int qtde;

//funcao principal
int main(int argc, char **argv) {
  int id;
  //inicializa o ambiente MPI e guarda o identificador do processo
  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &id);

  //o processo 0 sera o mestre, os demais serao escravos
  if (id == 0) mestre();
  else escravo(id);

  //finaliza o ambiente MPI
  MPI_Finalize();
  return 0;
}

//tarefa do mestre
void mestre(void) {
  int i=0, nodes, aux;
  long resultado[2];
  MPI_Status status;

  //guarda o numero de processos ativos
  MPI_Comm_size(MPI_COMM_WORLD, &nodes);
  //printf("N{e=%d}\n", nodes-1); //registro de log (numero de escravos)
  
  //aguarda as requisicoes e envia todas as tarefas
  for(i=0; i<N; i++) {
      MPI_Recv(0, 0, MPI_INT, MPI_ANY_SOURCE, TASKTAG, MPI_COMM_WORLD, &status); 
      MPI_Send(&i, 1, MPI_LONG, status.MPI_SOURCE, TASKTAG, MPI_COMM_WORLD);
      //printf("T0{d=%d, n=%d}\n", status.MPI_SOURCE, i); //registro de log
  }
  
  //recebe e trata os resultados de todas as tarefas
  for(i=1; i<N; i++) {
      //recebe os resultados em qualquer ordem
      MPI_Recv(&resultado, 2, MPI_LONG, MPI_ANY_SOURCE, RESULTAG, MPI_COMM_WORLD, &status);
      //printf("R0{f=%d, n=%d, r=%d}\n", status.MPI_SOURCE, resultado[0], resultado[1]); //registro de log
      trataResultado(resultado); 
  }

  //envia mensagem de termino para todos os processos
  for (aux=1; aux<nodes; aux++) {
    MPI_Send(0, 0, MPI_INT, aux, DIETAG, MPI_COMM_WORLD);
  }

  //imprime a qtde de primos encontrados
  printf("Qtde de primos = %lu\n", qtde);

}

//loop dos escravos
void escravo(int id) {
  int tarefa;
  long resultado[2]; //tarefa e resultado para envio para o mestre
  int req=0; //numero de tarefas solicitadas
  MPI_Status status;

  while (1) {
    //requisita uma tarefa
    MPI_Send(0, 0, MPI_INT, 0, TASKTAG, MPI_COMM_WORLD);
    //printf("Req{p=%d, req=%d}\n", id, ++req); //registro de log

    //espera pela tarefa (a tarefa é um numero inteiro para verificar se eh primo)
    MPI_Recv(&tarefa, 1, MPI_INT, 0, MPI_ANY_TAG, MPI_COMM_WORLD, &status);
    //printf("T{p=%d, n=%d}\n", id, tarefa); //registro de log

    //se a tarefa nao eh valida, termina
    if (status.MPI_TAG == DIETAG) { 
       //printf("Fim{p=%d}\n", id); //registro de log
       return;
    }

    //se tarefa valida, executa a tarefa
    resultado[0] = tarefa;
    resultado[1] = ehPrimo(tarefa);

    //envia o resultado usando a tag geral
    MPI_Send(&resultado, 2, MPI_LONG, 0, RESULTAG, MPI_COMM_WORLD);
    //printf("R{p=%d, n=%d, r=%d}\n", id, tarefa, resultado[1]); //registro de log
  }
}


//Trata o resultado recebido de um escravo
void trataResultado (long resultado[]) {
   if (resultado[1]) {
      qtde++;
      //printf("--%d\n", resultado[0]);
   }
}

//Tarefa dos processos trabalhadores
int ehPrimo (int n) {
      int i;
      if(n<=1) return 0;
      if(n==2) return 1;
      if(n%2==0) return 0;
      for(i=3; i<sqrt(n)+1; i+=2) {
         if(n%i==0) return 0;
      }
      return 1;
}
