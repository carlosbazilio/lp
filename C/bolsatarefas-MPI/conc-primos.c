/* Disciplina: Computacao Concorrente */
/* Prof.: Silvana Rossetto */
/* Codigo: Encontrar os números primos entre 0 e 10^? */

/* Versao concorrente */

#include <stdio.h>
#include <stdlib.h> 
#include <math.h>
#include <sys/time.h>
#include <pthread.h>
#include <semaphore.h>

#define NTHREADS  2 //alerar para o numero de threads desejado
#define N 1000000

volatile long numero = 0; //variavel compartilhada entre as threads
char primos[N]; //armazena o resultado do processamento (1:primo, 0:nao-primo)

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;  // lock para exclusao mutua entre as threads

//--funcao que verifica se o numero dado eh primo
int ehPrimo(long n) {
   int i;
      if(n<=1) return 0;
      if(n==2) return 1;
      if(n%2==0) return 0;
      for(i=3; i< sqrt(n)+1; i+=2) {
         if(n%i==0) return 0;
      }
      return 1;
}

//--funcao executada pelas threads
void *ExecutaTarefa (void * i) {
  unsigned long int n;  
  while(1) {
     pthread_mutex_lock(&mutex);
     n = numero; //pega o proximo numero
     if(n == N) { 
       pthread_mutex_unlock(&mutex);
       break; 
     }
     numero++;
     pthread_mutex_unlock(&mutex);
     primos[n] = ehPrimo(n);
  }
  pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
  pthread_t tid[NTHREADS];
  int t; unsigned long int i, qtde=0;
  
  struct timeval startTime, endTime;
  unsigned int totalUsecs;
  /* Inicia o contador de tempo */
  gettimeofday(&startTime, NULL);

  //--cria as threads
  for(t=0; t<NTHREADS; t++) {
    if (pthread_create(&tid[t], NULL, ExecutaTarefa, NULL)) {
      printf("--ERRO: pthread_create()\n"); exit(-1);
    }
  }

  //--espera todas as threads terminarem
  for (t=0; t<NTHREADS; t++) {
    if (pthread_join(tid[t], NULL)) {
         printf("--ERRO: pthread_join() \n"); exit(-1); 
    } 
  }

  /* Encerra o contador de tempo */
  gettimeofday(&endTime, NULL);
  totalUsecs = (unsigned long long) (endTime.tv_sec - startTime.tv_sec) * 1000000 +
               (unsigned long long) (endTime.tv_usec - startTime.tv_usec);
  
  //--contabiliza o numero de primos
  for(i=0;i<N;i++) {
     if(primos[i]) qtde++; 
  }

  printf("Valor final de numero = %lu\n", numero);
  printf("Qtde de primos = %lu\n", qtde);
  printf("%s%g\n", "Tempo = ", (double)totalUsecs);

  pthread_exit(NULL);
}
