#include "stdio.h"
#include "stdlib.h"

typedef struct estrutura {
	int b[100];
} estrutura;

estrutura *valores[100];

estrutura **f (int x) {
	return &(valores[x]);
}

int main() {
	int a = 0, c = 0;
	valores[0] = malloc(sizeof(estrutura));
	valores[1] = malloc(sizeof(estrutura));
	valores[2] = malloc(sizeof(estrutura));
	valores[3] = malloc(sizeof(estrutura));

	(*(f(a)+3))->b[c] = 2;

	printf("%d\n", valores[3]->b[0]);

	return 0;
}


