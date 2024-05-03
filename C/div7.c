#include <stdio.h>
#include <stdlib.h>

int div7 (int n) {
	printf("%d\n", n);
	if (n == 7)
		return 1;
	if (n < 7)
		return 0;
	return div7 (((n % 10) * 5) + (n / 10));
}

int main(int argc, char const *argv[])
{
	printf("%s\n", div7(atoi(argv[1])) == 1 ? "É divisível por 7" : "Não é divisível por 7");
	return 0;
}

