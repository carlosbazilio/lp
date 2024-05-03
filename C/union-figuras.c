#include <stdio.h>

#define MAX_FIGURAS 1000

typedef struct circulo {
	int diametro;
} tcirculo;

typedef struct retangulo {
	int base, altura;
} tretangulo;

typedef struct tforma {
	tretangulo ret;
	tcirculo circ;
} tforma;

typedef union uforma {
	tretangulo ret;
	tcirculo circ;
} uforma;

uforma figuras[MAX_FIGURAS];

void desenha(uforma f) {
	printf("%d\n", f.ret.altura);
}

int main(int argc, char const *argv[]) {
	// Preenchimento do vetor figuras
	tretangulo ret1 = {10, 20};
	tcirculo circ1 = {5};
	figuras[0].ret = ret1;
	figuras[1].circ = circ1;

	for (int i = 0; i < 2; ++i) {
		desenha(figuras[i]);
	}

	printf("sizeof(tforma) = %lu, sizeof(uforma) = %lu\n", 
		   sizeof(tforma),
           sizeof(uforma));

	return 0;
}