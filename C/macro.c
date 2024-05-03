#include "stdio.h"

#define N1 10
#define N2 20
#define troca(a, b) {int tmp; tmp = a; a = b; b = tmp;}

#define acessa(i) vetor[i]

int vetor[] = {1,2,3,4,5};

void ftroca(int *x, int *y) {
	int aux;
	aux = *x;
	*x = *y;
	*y = aux;
}

int main() {
	int x = N1, y = N2;
	troca(x, y);
	ftroca(&x, &y);
	printf("Valor de x e y: %d e %d\n", x, y);
	printf("%d\n", acessa(3));

	return 0;
}

