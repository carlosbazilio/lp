#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "stdarg.h"

typedef struct tdado {
	void *dado;
	size_t tipo;
} tdado;

int main() {
	int *x = (int *)malloc(sizeof(int));
	*x = 10;
	char y[] = "bazilio";
	tdado vet[] = {{x, sizeof(x)}, {y, sizeof(y)}};
	return 0;
}




