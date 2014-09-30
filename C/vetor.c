#include "stdio.h"
#include "stdlib.h"

main() {
	int n;
	printf("Entre com o tamanho do vetor: ");
	scanf("%d", &n);
	float v[n];
	v[n-1] = 150.0;
	printf("%g\n", v[n-1]);
}

	