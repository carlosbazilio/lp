
#include "stdio.h"

typedef struct ponto3D {
	int x, y, z;
} ponto3D;

ponto3D move(ponto3D *ponto, ponto3D *incremento);

int funcao(X);

int main() {
	ponto3D ponto = {0,0,0};
	funcao(ponto[0]);
	funcao(ponto);
	funcao(&ponto);
	funcao(move);
	funcao(move(&ponto, &ponto));

	return 0;
}
