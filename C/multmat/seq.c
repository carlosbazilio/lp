/* Disciplina: Computacao Concorrente */
/* Prof.: Silvana Rossetto */
/* Codigo: Multiplicacao de matrizes em C */
/* Versao 0: código sequencial */
/* Monitores: Lucas Arnaud, Vinicius Mendes Kastrup Magalhães, Victor Campos */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>

//variáveis globais
float **mat1, **mat2, **mat3;
int linha1, col1, linha2, col2;

//calcula uma linha na matriz de saida
void calculaLinha(int numLinha){
	int i, j, n = (int) numLinha;
        float m;
	for (i = 0; i < col2; i++){
		m = 0;
		for (j = 0; j < col1; j++){
			m += mat1[n][j] * mat2[j][i];
		}
		mat3[n][i] = m;
	}
}

//calcula o intervalo de tempo em microsegundos
unsigned int calculaTempo(struct timeval startTime, struct timeval endTime) {
	unsigned int totalSecs;

	totalSecs = (unsigned long long) (endTime.tv_sec - startTime.tv_sec) * 1000000 +
               (unsigned long long) (endTime.tv_usec - startTime.tv_usec);

    return totalSecs;
}

//imprime o tempo de processamento
void imprimeTempos(unsigned int processTime)  {
	printf("%g ", (double)processTime);
}

//função principal
int main(int argc, char *argv[]) {
	int i, j, k;	
	FILE *fentrada1, *fentrada2, *fsaida; //arquivos de entrada e saida

	// variáveis para calcular o tempo
	struct timeval startTime, endTime;
	unsigned int inputTime, processTime, storageTime;
	char entrada1[80], entrada2[80], saida[80];
	
	//argc -> numero de parametros (inclui nome do arquivo)
	//argv ->parametros (primeiro parametro eh o nome do arquivo)
	if(argc != 4) {
		puts("São necessários 3 parâmetros: <arq-mat1> <arq-mat2> <arq-saida>");
		return -1;
	}

	//abre os arquivos de entrada
	strcpy(entrada1, argv[1]);
	strcpy(entrada2, argv[2]);
	strcpy(saida, argv[3]);
			
	fentrada1 = fopen(entrada1, "r");
	fentrada2 = fopen(entrada2, "r");
	//a primeira linha dos arquivos de entrada contem o numero de linhas e colunas da matriz
	fscanf(fentrada1,"%d %d", &linha1, &col1);
	fscanf(fentrada2,"%d %d", &linha2, &col2);
	//simplificacao do problema: trata apenas matrizes quadradas
	if(col1 != linha2) {
		puts("Número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz.");
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

	//!!!!!!!!!!!!inicia o contador para o tempo de processamento!!!!!!!!!!!!!!
  	gettimeofday(&startTime, NULL);
	
	//multiplica as matrizes
	for (k=0;k<linha1;k++) {
		calculaLinha(k);
	}

	//!!!!!!!!!!!!encerra o contador para tempo de processamento!!!!!!!!!!!!!!!
  	gettimeofday(&endTime, NULL);
  	processTime = calculaTempo(startTime, endTime);

	//imprime a matriz resultante no arquivo de saida
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
