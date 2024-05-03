#include <omp.h>
#include <stdio.h>

#define TAM 10

int main (int argc, char *argv[]) {
	int th_id, nthreads;
	double **m1, **m2, **m3;
	
	for (int i = 0; i<TAM; i++) {
		#pragma omp parallel private(th_id, i)
		{
			/*th_id = omp_get_thread_num();
			printf("Hello World from thread %d\n", th_id);*/
			for (int j = 0; j<TAM; j++) {
				for (int k = 0; k<TAM; k++) {
					m3[i][j] = m3[i][j] + m1[i][k]*m2[k][j]
				}
			}
			
			#pragma omp barrier
			if ( th_id == 0 ) {
				/*nthreads = omp_get_num_threads();*/
				printf("Fim da execucao!\n");
			}
		}
	}
	return 0;
}
