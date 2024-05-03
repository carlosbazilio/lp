#include "stdio.h"

void func (int *x) {
	printf("%p\n", x);
	*x = *x + 10;
}

int main(int argc, char const *argv[]) {
	int local = 10;
	func(&local);
	printf("%d\n", local);
	printf("%p\n", &local);
	return 0;
}

