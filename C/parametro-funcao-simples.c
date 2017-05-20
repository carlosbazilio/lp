// gcc -pg parametro-funcao-simples.c -o parametro
// ./parametro
// gprof parametro ==> Gera profile de execução; importante flag -pg de gcc

#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "stdarg.h"

float frac(int);
float harmonico(int, int, float f(int));

float frac(int k) {
	return (1.0/k);
}

float frac2(int k) {
	return (1.0/(k*k));
}

float harmonico(int lo, int hi, float f(int)) {
	float temp = 0;
	int i;
	for (i=lo; i<=hi; i++)
		temp = temp + f(i);
	return temp;
}

typedef float (* tfuncao)(int);

main() {
	tfuncao vet[] = {frac, frac2};

	printf("Valor do harmonico: %f\n", harmonico(1, 100, frac2));
}



