#include "stdio.h"
#include "stdlib.h"

// Compilar com opção -fnested-functions

int f (int x) {
	int g(int w) {
		return w;
	}
	return g(x);
}

int main() {
	printf("%d\n", f(10));
	return 0;
}
