#include "stdio.h"
#include "stdlib.h"

void func (int *x) {
	*x = *x + 10;
}

void funcref (int &x) {
	x = x + 10;
}

int main(int argc, char const *argv[]) {
	int local = 10;
	
	//func(&local);
	funcref(local);
	printf("%d\n", local);
	
	return 0;
}


