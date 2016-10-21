#include <stdio.h>

int fat (int);

main()
{
  	printf("%d\n", fat(6));
}

fat (x) {
	if (x == 0)
		return 1; // Erro: valor base é 1
	else
    	return x * fat(x - 1);
}


