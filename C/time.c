#include <time.h>
#include <stdio.h>

main(void)
{
  time_t inicio, fim;
  int i;

  inicio=time(NULL);
  // Formato retornado pela asctime: DDD MMM dd hh:mm:ss YYYY
  printf("The current time is %s.\n",asctime(localtime(&inicio)));
  sleep(3);
  for (i=0; i<1000000; i++)
  	printf(" ");
  fim=time(NULL);
  printf("\nDiff tempo = %f\n", (float)(fim - inicio));
}


	