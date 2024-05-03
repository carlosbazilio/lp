#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define TAM 10

typedef struct tmultmatriz {
    int linha;
    double **matrizA, **matrizB, **matrizC;
} tmultmatriz;

double ** aloca_matriz(int m, int n) {
	int i;
	double **res = (double **) malloc (m*sizeof(double *));
	for (i=0; i<n; i++)
		res[i] = (double *) malloc (TAM*sizeof(double));
	return res;
}

void remove_matriz(double **mat) {
	int i;
	for (i=0; i<TAM; i++)
		free(mat[i]);
	free(mat);
}

void *mult_matrizes_task (void *args) {
	tmultmatriz *args_mult = (tmultmatriz *)args;
	int j, k;
	int i = args_mult->linha;
	double **a = args_mult->matrizA;
	double **b = args_mult->matrizB;
	double **c = args_mult->matrizC;
	
	for (j=0; j<TAM; j++)
		for (k=0; k<TAM; k++) 
			c[i][j] = c[i][j] + a[i][k]*b[k][j];
	sleep(1);

	return c;
}

double ** mult_matrizes (double **m1, double **m2) {
	int i, j, k;
	double **res = aloca_matriz(TAM, TAM);
	
	pthread_t threads[TAM];

	tmultmatriz *args_mult = (tmultmatriz *)malloc(sizeof(tmultmatriz));
	args_mult->matrizA = m1;
	args_mult->matrizB = m2;
	args_mult->matrizC = res;
	
	for (i=0; i<TAM; i++) {
		args_mult->linha = i;
		pthread_create(&threads[i], NULL, mult_matrizes_task, (void *)args_mult);
		//mult_matrizes_task(args_mult);
	}
	
	/* wait for all threads to complete */
	for (i=0; i<TAM; ++i)
		pthread_join(threads[i], NULL); 
	
	return res;
}

double ** aleatorio () {
	int i, j;
	double **res = aloca_matriz(TAM, TAM);
	
	for (i=0; i<TAM; i++) {
		for (j=0; j<TAM; j++) {
			res[i][j] = rand() % 10;
		}
	}
	return res;
}

void exibe (double **matriz) {
	int i, j;
	
	for (i=0; i<TAM; i++) {
		for (j=0; j<TAM; j++) {
			printf("%g ", matriz[i][j]);
		}
		printf("\n");
	}
}

int main()
{
	time_t inicio, fim;
	int i;
	double **A, **B, **C;
	
	A = aleatorio();
	B = aleatorio();

	exibe(A);
	exibe(B);
	
	inicio=time(NULL);
	C = mult_matrizes(A, B);
	fim=time(NULL);

	exibe(C);

	// Formato retornado pela asctime: DDD MMM dd hh:mm:ss YYYY
	//printf("The current time is %s\n",asctime(localtime(&inicio)));	
	//printf("\nDiff tempo = %f\n", (double)(fim - inicio));
	printf("\nDiff tempo = %f\n", difftime(fim, inicio));
	
	remove_matriz(A);
	remove_matriz(B);
	remove_matriz(C);

	return 0;
}

