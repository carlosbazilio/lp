#include <signal.h>
#include <setjmp.h>
#include <stdio.h>
#include <stdlib.h>

int i, j;
long T0;
jmp_buf Env;

void alarm_handler(int dummy)
{
  long t1;

  t1 = time(0) - T0;
  printf("%ld second%s has passed: j = %d.  i = %d\n", t1, 
     (t1 == 1) ? "" : "s", j, i);
  if (t1 >= 8) {
    printf("Giving up\n");
    longjmp(Env, 1);
  }
  alarm(1);
  signal(SIGALRM, alarm_handler);
}

main()
{
  signal(SIGALRM, alarm_handler);
  alarm(1);

  if (setjmp(Env) != 0) {
    printf("Gave up:  j = %d, i = %d\n", j, i);
    exit(1);
  }

  T0 = time(0);

  for (j = 0; j < 10000; j++) {
    for (i = 0; i < 1000000; i++)
    	//printf("Main: %d, %d\n", i, j);
  }
}

