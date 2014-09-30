#include "stdio.h"

int fat_aux(int n, int acum) {
	if (n == 1)
		return acum;
	else
		return fat_aux(n-1, acum*n);
}

int fat(int n) {
	return fat_aux(n, 1);
}

int fat2(int n) {
	if (n == 0)
		return 1;
	else
		return n * fat2(n-1);
}

int main(int argc, char const *argv[])
{
	printf("%d\n", fat(5));
	printf("%d\n", fat2(5));
	return 0;
}
