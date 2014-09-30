#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "stdarg.h"

float frac(int k, ...) {
	va_list args;
	va_start(args, k);
	int proxi = va_arg(args, int);
	int proxi2 = va_arg(args, int);
	va_end(args);
	//return k / proxi;
	return k * proxi * proxi2;
}

float harmonico(int lo, int hi, float f(int, ...)) {
	float temp = 0;
	int i;
	for (i=lo; i<=hi; i++)
		temp = temp + f(i, 10, 20);
	return temp;
}

main() {
	printf("Valor do harmonico: %f\n", harmonico(1, 3, frac));
}
