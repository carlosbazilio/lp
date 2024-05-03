#include "stdio.h"
#include "teste.h"
#include "teste2.h"

int fat(int x) {
	if (x == 0)
		return 1;
	return x * fat(x-1);
}

int main(int argc, char const *argv[])
{
	int x = 5;
	printf("%d\n", fat(x=x+1));
	printf("%d\n", x);
	return 0;
}



