#include "stdio.h"

main() {
	int num, numoriginal, cont = 0, raiz = 0, i=1;
	scanf("%d", &num);
	numoriginal = num;

	for (i=1; num>0; i=i+2) {
		num = num - i;
		cont++;
		if (num <= 0) {
			raiz = cont;
		}
	}
	printf("Raiz de %d eh %d\n", numoriginal, raiz);
}
