#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "stdarg.h"

float frac(int k) {
	return 1.0/k;
}

float frac2(int k) {
	return 1.0/(1.0 - k);
}

float frac3(int k) {
	return k;
}

float frac4(int k, ...) {
	va_list args;
	va_start(args, k);
	int proxi = va_arg(args, int);
	va_end(args);
	return k * proxi;
}

float frac5 (int k) {
	return ++k;
}

float frac6(int k, ...) {
	va_list args;
	va_start(args, k);
	int proxi = va_arg(args, int);
	int proxi2 = atoi(va_arg(args, char *));
	va_end(args);
	return k + proxi + proxi2;
}

float harmonico(int lo, int hi, float f(int, ...)) {
	float temp = 0;
	int i;
	for (i=lo; i<=hi; i++)
		temp = temp + f(i, 10, "10", 105.323, temp, harmonico, f);
	return temp;
}

int main() {
	printf("Valor do harmonico: %f\n", harmonico(1, 3, frac6));
	return 0;
}
