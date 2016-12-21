#include "stdio.h"

int pot (int x, int y) {
	int aux = 1, i;
	for (i=1; i<=y; i++)
		aux = aux * x;
	return aux;
}

int pot2 (int x, int y) {
	if (y == 0)
		return 1;
	else
		return x * pot2(x, y-1);
}

int pot3 (int x, int y) {
	return (y == 0) ? 1 : x * pot3(x, y-1);
}

main() {
	printf("%d\n", pot3(2,3));
}
