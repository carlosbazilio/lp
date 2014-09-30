#include "stdio.h"
#include "stdlib.h"

int main() {
	int *v = (int *)malloc(sizeof(int)*10);
	v[8] = 5;
	v[9] = 15;
	int *w = &v[9];
	v = NULL;
	printf("%d\n", *(w-1));
	return 0;
}
