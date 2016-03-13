#include "stdio.h"

void soma(int &v) {
	v = 10;
}

main() {
	//int v[] = {1, 2, 3};
	int v;
	soma(v);
	printf("%d\n", v);
}
