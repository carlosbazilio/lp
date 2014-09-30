/* Disciplina: Computacao Concorrente */
/* Prof.: Silvana Rossetto */
/* Codigo: Multiplicacao de matrizes em C */
/* Versão 3: concorrente com uma thread para cada elemento da matriz resultante */
/* Monitores: Lucas Arnaud, Vinicius Mendes Kastrup Magalhães, Victor Campos */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include <sys/time.h>

//variaveis globais
float **mat1, **mat2, **mat3;
int linha1, col1, linha2, col2;

typedef struct   //estrutura para passar mais de um valor
{				 //como parametro para as threads
	int i, j;	// i-> posicao da linha
} posicao;		// j-> posicao da coluna

//calcula um elemento na matriz de saida
void *calculaElemento(void *posEl){
	int linha = ((posicao*) posEl)->i;
	int coluna = ((posicao*) posEl)->j;
	int i;
        float m;
	
	free(posEl);
	
	m = 0;
	for (i = 0; i < col1; i++){
		m += mat1[linha][i] * mat2[i][coluna];
	}
	mat3[linha][coluna] = m;
}

//calcula o tempo de processamento em microsegundos
unsigned int calculaTempo(struct timeval startTime, struct timeval endTime) {
	unsigned int totalSecs;

	totalSecs = (unsigned long long) (endTime.tv_sec - startTime.tv_sec) * 1000000 +
               (unsigned long long) (endTime.tv_usec - startTime.tv_usec);

    return totalSecs;
}

//imprime os tempos de processamento
void imprimeTempos(unsigned int processTime)  {
	printf("%s%g ms\n", "Tempo de Processamento = ", (double)processTime);
}

//funcao principal
int main(int argc, char *argv[]) {
	int i, j, k;	
	pthread_t *tid;
	FILE *fentrada1, *fentrada2, *fsaida;
	posicao *pos;

	// variáveis para calcular o tempo
	struct timeval startTime, endTime;
	unsigned int inputTime, processTime, storageTime;
	char entrada1[80], entrada2[80], saida[80];
	
	//argc -> numero de parametros (inclui nome do arquivo)
	//argv ->parametros (primeiro parametro eh o nome do arquivo)
	//le os parametros dados pela linha de comando
        if(argc != 4) {
                puts("São necessários 3 parâmetros: <arq-mat1> <arq-mat2> <arq-saida>");
                return -1;
        }

	strcpy(entrada1, argv[1]);
	strcpy(entrada2, argv[2]);
	strcpy(saida, argv[3]);
	
	//abre os arquivos de entrada para leitura		
	fentrada1 = fopen(entrada1, "r");
	fentrada2 = fopen(entrada2, "r");
	
	//le os numeros de linhas e colunas das matrizes de entrada
	fscanf(fentrada1,"%d %d", &linha1, &col1);
	fscanf(fentrada2,"%d %d", &linha2, &col2);
	//simplificacao do problema: trata apenas matrizes quadradas
	if(col1 != linha2) {
		puts("Número de colunas da primeira matriz deve ser igual ao número de linhas da segunda!");
		return -1;
	}
	
	//aloca e le a primeira matriz
	mat1 = (float**) malloc(sizeof(float*)*linha1);
	
	for(i = 0; i < linha1; ++i)
	{
		mat1[i] = (float*) malloc(sizeof(float)*col1);
		for(j = 0; j < col1; ++j)
		{
			fscanf(fentrada1, "%f", &mat1[i][j]);
		}
	}
	
	//aloca e le a segunda matriz
	mat2 = (float**) malloc(sizeof(float*)*linha2);
	
	for(i = 0; i < linha2; ++i)
	{
		mat2[i] = (float*) malloc(sizeof(float)*col2);
		for(j = 0; j < col2; ++j)
		{
			fscanf(fentrada2, "%f", &mat2[i][j]);
		}
	}

	//aloca a matriz resultado
	mat3 = (float**) malloc(sizeof(float*)*linha1);
	for(i = 0; i < col2; ++i)
	{
		mat3[i] = (float*) malloc(sizeof(float)*col2);
	}
	
	//!!!!!!!!!!!!!!!!!inicia o contador para o tempo de processamento!!!!!!!!!!!!!!!!!!!!
  	gettimeofday(&startTime, NULL);
	
	//aloca vetor de threads
	tid = (pthread_t*) malloc(sizeof(pthread_t)*linha1*col2);
		
	//cria as threads responsaveis pela multiplicacao das matrizes
	for(i = 0; i < linha1; i++){
		for (j=0; j < col2; j++) {
			pos = (posicao *) malloc(sizeof(posicao));
			pos->i = i;
			pos->j = j;
			if (pthread_create(&tid[i*col1 + j], NULL, calculaElemento, (void *)pos)) {
				printf("--ERRO: pthread_create()\n"); exit(-1);
			}
		}
	}

	//espera todas as threads terminarem
	for (k = 0; k < linha1; k++){
		if (pthread_join(tid[k], NULL)) { 
			printf("--ERRO: pthread_join() \n"); exit(-1); 
		}
	}

	//!!!!!!!!!!!!!!!!!!!!!encerra o contador para tempo de processamento!!!!!!!!!!!!!!!!!!!
  	gettimeofday(&endTime, NULL);
  	processTime = calculaTempo(startTime, endTime);

	//imprime a matriz resultante em arquivo
	fsaida = fopen(saida, "w");
	for(i=0; i<linha1; i++) {
		for(j=0; j<col2; j++) {
			fprintf(fsaida, "%f ",mat3[i][j]);
		}
		fprintf(fsaida, "\n");
	}

  	imprimeTempos(processTime);

  	return 0;
}
