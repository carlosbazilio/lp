#include <stdio.h>

int fat(int x) {
	if (x == 0) {
		return 1;
	}
	return x * fat(x-1);
}

int fat_iter(int x, int *aux) {
	// static int aux = 1;
	while (x > 1) {
		*aux = *aux * x;
		x--;
	}
	return *aux;
}

int main() {
	int valor, auxiliar=1;
	printf("Digite um valor para o cálculo do fatorial: ");
	scanf("%d", &valor);
	printf("fat(%d) = %d\n", valor, fat_iter(valor, &auxiliar));
	printf("Digite um valor para o cálculo do fatorial: ");
	scanf("%d", &valor);
	printf("fat(%d) = %d\n", valor, fat_iter(valor, &auxiliar));
}


