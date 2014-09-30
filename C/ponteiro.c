#include "stdio.h"
#include "stdlib.h"

void f() {
	int *x;
	x = 1606416764;
	*x = 30;
	printf("Dentro de f: %d\n", x);
}

int main() {
	int y = 50;
	f();
	printf("Dentro da main: %d\n", y);
	printf("%d%d\n",'g', 'a');
	return 0;
}
