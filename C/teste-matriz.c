#include <stdio.h>

#define TAM 3

double media (int v[], int tamanho) {
	double soma = 0;
	int i;
	for (i = 0; i < tamanho; i++) {
		soma = soma + v[i];
	}
	return soma / tamanho;
}

int main(void)
{
	int m [TAM][TAM] = { {1, 2, 3}, {1, 2, 3}, {1, 2, 3} };
	int notas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	printf("Media: %g\n", media(m[1], TAM));
	printf("Media: %g\n", media(notas, 10));

	return 0;
}

