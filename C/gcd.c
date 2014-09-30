#include "stdio.h"

int gcd(int x, int y) {
	if ((x < 1) || (y < 1))
		return 0;
	else
		if (x == y)
			return x;
		else
			if (x < y)
				return gcd(x, y-x);
			else
				return gcd(x-y, y);
}

main() {
	int x, y;
	printf("Entre com 2 valores: ");
	scanf("%d%d", &x, &y);
	printf("O maior divisor comum entre %d e %d eh %d\n", x, y, gcd(x,y));
}

