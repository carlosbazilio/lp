#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "math.h"

struct lista_gen {
	void* info;
	void (* impressao)(void *); // Campo que representa uma função
	int (* compara)(void *, void *);
	struct lista_gen* prox;
};

typedef struct tReta {
	int x1, y1, x2, y2;
} tReta;

typedef struct lista_gen ListaGen;

ListaGen* insere(ListaGen *l, void* p, void impr(void *), int cmp(void *, void *));
void insere2(ListaGen **l, void* p, void impr(void *), int cmp(void *, void *));
int tamanho(ListaGen *l);
void imprimeString (void *p);
void imprimeNumero (void *p);

ListaGen* insere(ListaGen *l, void* p, void impr(void *), int cmp(void *, void *)) {
	ListaGen* n = (ListaGen *) malloc(sizeof(ListaGen));
	n->info = p;
	n->impressao = impr;
	n->compara = cmp;
	n->prox = l;
	return n;
}

void insere2(ListaGen **l, 
	         void* p, 
	         void impr(void *), 
	         int cmp(void *, void *)) {
	ListaGen* n = (ListaGen *) malloc(sizeof(ListaGen));
	n->info = p;
	n->impressao = impr;
	n->compara = cmp;
	n->prox = *l;
	*l = n;
}

int tamanho(ListaGen *l) {
	int tam = 0;
	ListaGen *laux;
	for (laux = l; laux != NULL; laux=laux->prox)
		tam++;
	return tam;
}

void imprimeString (void *p) {
	printf("%s\n", (char *)p);
}

void imprimeNumero (void *p) {
	printf("%d\n", *((int *)p));
}

void imprimeReta (void *p) {
	tReta *reta = (tReta *)p;
	printf("(%d,%d)-(%d,%d)\n", reta->x1, reta->y1, reta->x2, reta->y2);
}

int comparaReta (void *v1, void *v2) {
	tReta *r1 = (tReta *)v1;
	tReta *r2 = (tReta *)v2;

	double tam1 = sqrt(pow(r1->x1 - r1->x2, 2) + pow(r1->y1 - r1->y2, 2));
	double tam2 = sqrt(pow(r2->x1 - r2->x2, 2) + pow(r2->y1 - r2->y2, 2));

	if (tam1 > tam2)
		return 1;
	else
		if (tam1 < tam2)
			return -1;
	return 0;
}

int comparaInt (void *v1, void *v2) {
	int retorno;
	int *iv1 = (int *)v1;
	int *iv2 = (int *)v2;
	if (*iv1 == *iv2)
		retorno = 0;
	else
		if (*iv1 > *iv2)
			retorno = 1;
		else
			retorno = -1;
	return retorno;
}

int comparaString (void *v1, void *v2) {
	return strcmp ((char *)v1, (char *)v2);
}

void exibe(ListaGen *l) {
	ListaGen *laux;
	for (laux = l; laux != NULL; laux=laux->prox) {
		laux->impressao(laux->info);
	}
}

void limpa(ListaGen **l) {
	ListaGen *laux;
	laux = (*l);
	while (laux != NULL) {
		(*l) = (*l)->prox;
		free(laux->info);
		free(laux);
		laux = (*l);
	} 
}

int pertence(void *v, ListaGen *l) {
	while (l != NULL) {
		if (l->compara(l->info, v) == 0) {
			return 1;
		}
		l = l->prox;
	}
	return 0;
}

void *getAt(int posicao, ListaGen *l) {
	ListaGen *laux = l;
	while ((laux != NULL) && (posicao > 1)) {
		laux=laux->prox;
		posicao--;
	}
	if ((posicao < 1) || (laux == NULL)) { // Posição inválida!
		return NULL;
	}
	return laux->info;
}

int main() {
	ListaGen* l = NULL;
	char *nome;
	nome = (char *)malloc(sizeof(char)*10);
	strcpy(nome, "vinicius");
	//l = insere(l, nome, imprimeString, comparaString);
	insere2(&l, nome, imprimeString, comparaString);

	int *x = (int *)malloc(sizeof(int));
	(*x) = 10;
	//l = insere(l, x, imprimeNumero, comparaInt);
	insere2(&l, x, imprimeNumero, comparaInt);

	tReta *reta = (tReta *)malloc(sizeof(tReta));
	reta->x1 = 0; reta->y1 = 0; reta->x2 = 3; reta->y2 = 4;
	insere2(&l, reta, imprimeReta, comparaReta);

	printf("Tamanho da lista: %d\n", tamanho(l));
	exibe(l);
	int *y = (int *)malloc(sizeof(int));
	(*y) = 10;
	printf("Pertence no. %d à lista: %s\n", (*y), (pertence(y, l) == 1) ? "sim" : "não");
	char *str;
	str = (char *)malloc(sizeof(char)*10);
	strcpy (str, "vinicius");
	printf("Pertence no. %s à lista: %s\n", str, (pertence(str, l) == 1) ? "sim" : "não");
	limpa(&l);
	printf("Tamanho da lista: %d\n", tamanho(l));

	return 0;
}
