#include "stdio.h"
#include "stdlib.h"

int f (int x) {
	int g(int w) {
		return w;
	}
	return g(x);
}

int main() {
	int *v = (int *)malloc(sizeof(int)*10);
	v[8] = 5;
	v[9] = 15;
	int *w = &v[9];
	v = NULL;
	printf("%d\n", *(w-1));
	printf("%d\n", f(10));
	return 0;
}
