/* longjmp example */
#include <stdio.h>
#include <stdlib.h>
#include <setjmp.h>

main()
{
  jmp_buf env;
  int val;

  val=setjmp(env);

  printf ("val is %d\n",val);

  if (!val) longjmp(env, 1);

  return 0;
}

