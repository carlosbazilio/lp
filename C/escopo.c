#include "stdio.h"
#include "stdlib.h"

int a;

void first () {
	a = 1;
}

void second () {
	int a;
	first();
}

int main() {
	int aux;
	a = 2;
	scanf("%d", &aux);
	if (aux > 0) {
		second();
	}
	else
		first();
	printf("%d\n", a);
	return 0;
}