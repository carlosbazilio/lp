#include "stdio.h"

#define troca(A, B) {int tmp; tmp = A; A = B; B = tmp;}

main() {
	int x = 10, y = 20;
	troca(x, y);
	// Chamada da mesma macro não redefine tmp, pois
	//esta é definida dentro do bloco expandido
	troca(x, y);
	printf("Valor de x e y: #d e #d\n", x, y);
}

