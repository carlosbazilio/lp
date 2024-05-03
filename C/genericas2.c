#include "stdio.h"
#include "stdlib.h"

struct lista_gen {
	void* info;
	// void desenha(void *);
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

typedef struct ponto3D {
	float x, y;
} tponto3D;

ListaGen* insere(ListaGen *l, void* p, void des(void *)) {
	ListaGen* n = (ListaGen *) malloc(sizeof(ListaGen));
	n->info = p;
	n->desenha = des;
	n->prox = l;
	return n;
}

void desenhaCirculo (void *p) {
	printf("Circulo com raio: %.2f\n", ((tCirculo *)p)->raio);
}

void desenhaQuadrado (void *p) {
	int i, j;
	tQuadrado *quad = (tQuadrado *)p;
	printf("Quadrado: %.2f, %.2f\n", quad->l1, quad->l2);
}

void desenha(ListaGen *l) {
	ListaGen *laux;
	for (laux = l; laux != NULL; laux=laux->prox) {
		laux->desenha(laux->info);
	}
}

void desenhaInteiro(void *p) {
	printf("%d\n", *(int *)p);
}

void desenhaPonto3D(void *p) {
	tponto3D *aux = (tponto3D *)p;
	printf("(%f,%f)\n", aux->x, aux->y);
}

int main() {
	ListaGen* l = NULL;
	tCirculo *circulo1 = (tCirculo *)malloc(sizeof(tCirculo));
	circulo1->raio = 3.5;
	l = insere(l, circulo1, desenhaCirculo);
	tQuadrado *quadrado1 = (tQuadrado *)malloc(sizeof(tQuadrado));
	quadrado1->l1 = 3.0;
	quadrado1->l2 = 3.0;
	l = insere(l, quadrado1, desenhaQuadrado);
	int *x = (int *)malloc(sizeof(int));
	*x = 10;
	l = insere(l, x, desenhaInteiro);
	tponto3D *p3d = (tponto3D *)malloc(sizeof(tponto3D));
	p3d->x = 10; p3d->y = 10; //p3d->z = 10;
	l = insere(l, p3d, desenhaQuadrado);
	desenha(l);
	return 0;
}
