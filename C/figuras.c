// Union

#define MAX_FIGURAS 1000

typedef struct circulo {
	int diametro;
} tcirculo;

typedef struct retangulo {
	int base, altura;
} tretangulo;

typedef struct forma {
	tretangulo ret;
	tcirculo circ;
} tforma;

tforma figuras[MAX_FIGURAS];

void desenha(tforma f) {
	// printf("%s\n", );
}

int main(int argc, char const *argv[]) {
	// Preenchimento do vetor figuras
	tretangulo ret1 = {10, 20};
	tcirculo circ1 = {5};
	figuras[0].ret = ret1;
	figuras[1].circ = circ1;

	for (int i = 0; i < MAX_FIGURAS; ++i) {
		desenha(figuras[i]);
	}
	return 0;
}