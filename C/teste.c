
#include "stdio.h"

void f(int *x) {
	printf("%p, %d\n", x, *x);
}

main() {
	f(20 & 10);
}


