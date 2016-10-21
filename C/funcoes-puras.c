// https://gcc.gnu.org/onlinedocs/gcc/Function-Attributes.html

#include "stdio.h"
#include "stdlib.h"

int g = 10;

__attribute__ ((pure)) 
int f (int x) {
	return x * x;
}

int f2 () {
	return g * g;
}

int main() {
	int i;
	for (i=0; i<1000; i++)
		printf("%d\n", f(10));
	return 0;
}
