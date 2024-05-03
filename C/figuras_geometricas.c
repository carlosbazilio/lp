
// Retangulos (x, y), Circulos (raio), Quadrados (l)

#include "stdio.h"

#define TAM_FIGURAS 10

typedef struct tretangulo {
	double x, y;
} tretangulo;

typedef struct tcirculo {
	double raio;
} tcirculo;

typedef struct tfigura {
	tretangulo retangulo;
	tcirculo circulo;
} tfigura;

tfigura figuras[TAM_FIGURAS];

void desenha (tfigura figura) {
	
}

main() {
	for (int i=0; i<TAM_FIGURAS; i++)
		desenha(figuras[i]);
}

