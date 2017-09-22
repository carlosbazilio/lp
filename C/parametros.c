
#include "stdio.h"

void g (out int w) {
	w = 1;
	printf("%d\n", w);
}

int g2 () {
	int w = 1;
	return w;
}

int g3 (int x) {
	return x + 1;
}

int main() {
	int k = 1;
	//g(k);
	printf("%d\n", g3 (g2 ()));
	return 0;
}
