#include "stdio.h"
#include "stdlib.h"

struct lista_gen {
	void* info;
	void (* desenha)(void *); // Campo que representa uma função
	struct lista_gen* prox;
};

typedef struct lista_gen ListaGen;

ListaGen* insere(ListaGen *l, void* p, void impr(void *));

typedef struct circulo {
	float raio;
} tCirculo;

typedef struct quadrado {
	float l1, l2;
} tQuadrado;

ListaGen* insere(ListaGen *l, void* p, void des(void *)) {
	ListaGen* n = (ListaGen *) malloc(sizeof(ListaGen));
	n->info = p;
	n->desenha = des;
	n->prox = l;
	return n;
}

void desenhaCirculo (void *p) {
	printf("Raio: %f\n", ((tCirculo *)p)->raio);
}

void desenhaQuadrado (void *p) {
	int i, j;
	tQuadrado *quad = (tQuadrado *)p;
	printf("Quadrado: %f, %f\n", quad->l1, quad->l2);
}

void desenha(ListaGen *l) {
	ListaGen *laux;
	for (laux = l; laux != NULL; laux=laux->prox) {
		laux->desenha(laux->info);	
	}
}

main() {
	ListaGen* l = NULL;
	tCirculo *circulo1 = (tCirculo *)malloc(sizeof(tCirculo));
	circulo1->raio = 3.5;
	l = insere(l, circulo1, desenhaCirculo);
	tQuadrado *quadrado1 = (tQuadrado *)malloc(sizeof(tQuadrado));
	quadrado1->l1 = 3.0;
	quadrado1->l2 = 3.0;
	l = insere(l, quadrado1, desenhaQuadrado);
	desenha(l);
}
