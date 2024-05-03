
#include "stdio.h"

void fat2(int n, int *res) {
	if (n > 1) {
		*res = *res * n;
		fat2(n-1, res);
	}
}

int fat(int n) {
	if ((n == 0) || (n == 1))
		return 1;
	return n * fat(n-1);
}

int comb(int x, int y) {
	return fat(x) / (fat(y) * (fat(x-y)));
}

int main() {
	int resultado = 1;
	fat2 (5, &resultado);
	printf("%d\n", resultado);
	printf("%d\n", fat(5)); // 120
	printf("%d\n", fat(5)); // 120
	printf("%d\n", comb(4,3)); // 4
	return 0;
}
