#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "stdarg.h"

double frac(int k) {
	return 1/k;
}

double harmonico(int lo, int hi, double f(int)) {
	double temp = 0;
	int i;
	for (i=lo; i<=hi; i++)
		temp = temp + f(i);
	return temp;
}

main() {
	printf("Valor da soma: %f\n", harmonico(1, 5, frac));
}
