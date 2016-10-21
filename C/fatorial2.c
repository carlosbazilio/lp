#include <stdio.h>

int fat (int x) {
	int aux = x, aux2 = 1;
	while (aux2 <= aux) { // Erro < x
		aux = aux * aux2;
		aux2++;
	}
	return aux;
}

main() {
	printf("%d\n", fat(5));
}

