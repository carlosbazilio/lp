#include "stdio.h"

int main() {
	int a = 10;
	int b;
	b = &a;
	printf ("%u", *((int *)b));
	return 0;
}