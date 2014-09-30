#include "stdio.h"
#include "stdlib.h"

typedef struct celula {
	int *val;
	int cont;
} tcelula;

tcelula *heap;

int * maloca () {
	return NULL;
}

void inicializa() {
	heap = (tcelula *) malloc(1000*sizeof(tcelula));
}

main() {
	inicializa();
	printf("Valor %d: \n", heap[0].cont);
}
