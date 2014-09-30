/* Disciplina: Computacao Concorrente */
/* Prof.: Silvana Rossetto */
/* Codigo: Encontrar os números primos entre 0 e 10^? */

/* Versao sequencial */

#include <stdio.h>
#include <stdlib.h> 
#include <math.h>
#include <sys/time.h>

#define N 1000000

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

//--funcao principal
int main(int argc, char *argv[]) {
  unsigned long int i, qtde=0;
  
  struct timeval startTime, endTime;
  unsigned int totalUsecs;

  /* inicia o contador de tempo */
  gettimeofday(&startTime, NULL);
  
  for(i=0; i<N; i++) { 
     if (ehPrimo(i)) qtde++;
  }

  /* encerra o contador de tempo */
  gettimeofday(&endTime, NULL);
  totalUsecs = (unsigned long long) (endTime.tv_sec - startTime.tv_sec) * 1000000 +
               (unsigned long long) (endTime.tv_usec - startTime.tv_usec);
  
  printf("Valor final de numero = %lu\n", i);
  printf("Qtde de primos = %lu\n", qtde);
  printf("%s%g\n", "Tempo = ", (double)totalUsecs);
}
