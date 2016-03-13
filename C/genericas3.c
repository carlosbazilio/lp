#include "stdio.h"
#include "stdlib.h"
#include "string.h"

typedef struct produto {
	int codigo;
	char nome[20];
	double preco;
} tproduto;

int soma(int vet[10]) {
	int i, soma = 0;
	for (i=0; i<10; i++)
		soma = soma + vet[i];
	return soma;
}

double somaPrecos(tproduto vet[3]) {
	int i;
	double soma = 0;
	for (i=0; i<3; i++)
		soma = soma + vet[i].preco;
	return soma;
}

double somaValores(void *vet[], int tam, double elem(void *)) {
	int i;
	double soma = 0;
	for (i=0; i<tam; i++) {
		soma = soma + elem(vet[i]);
	}
	return soma;
}

int *alocaValor(int n) {
	int *v = (int *)malloc(sizeof(int));
	*v = n;
	return v;
}

double retornaValor (void *p) {
	return *((int *) p);
}

tproduto *alocaProduto(int c, char *n, double p) {
	tproduto *prod = (tproduto *)malloc(sizeof(tproduto));
	prod->codigo = c;
	strcpy(prod->nome, n);
	prod->preco = p;
	return prod;
}

double retornaPreco (void *p) {
	return ((tproduto *) p)->preco;
}

main() {
	int valores[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	printf("%d\n", soma(valores));
	tproduto produtos[] = {{1, "arroz", 5.5}, {2, "feijao", 8}, {3, "açúcar", 3}};
	printf("%3.2f\n", somaPrecos(produtos));

	void *valores2[] = {alocaValor(1), alocaValor(2), alocaValor(3), alocaValor(4), alocaValor(5)};
	printf("%3.2f\n", somaValores(valores2, 5, retornaValor));
	void *produtos2[] = {alocaProduto(1, "arroz", 5.5), alocaProduto(2, "feijao", 8)};
	printf("%3.2f\n", somaValores(produtos2, 2, retornaPreco));
}


