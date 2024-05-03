#include <stdio.h>

int aplicaInvestimento (float valor) {
	int saldo = valor * 10;
	return saldo;
}

int main() {
	printf("%d", aplicaInvestimento(5.03));
}



