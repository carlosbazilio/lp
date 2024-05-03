#include <stdio.h>
#include <stdlib.h>

int fat (int x) {
	return 1;
}

int fib (int x) {
	return 2;
}

int main(int argc, char const *argv[])
{
	int aux = 10;
	void *f = malloc(sizeof(int));
	*((int *)f) = 100;
	printf("%d\n", *(int *)f);
	f = fib;
	// f(10);
	printf("%d\n", ((int (*)(int))(f))(10));
	f = &aux;
	printf("%p\n", (int *)f);
	return 0;
}