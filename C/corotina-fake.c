#include "stdio.h"
#include "stdlib.h"

void corotina (int modo) {
	// Variáveis locais
	// ...
	if (modo == 0) {
		// Comandos da Corotina 0
		// ...
		corotina(1);
	}
	else {
		// Comandos da Corotina 1
		// ...
		corotina(0);
	}
}
