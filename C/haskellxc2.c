#include "stdio.h"
#include "stdlib.h"

typedef struct lista {
    int valor;
    struct lista *proximo;
} lista;

lista *insere(lista *l, int v) {
    lista *aux = (lista *)malloc(sizeof(lista));
    aux->valor = v;
    aux->proximo = l;
    return aux;
}

int soma (lista *l) {
    if (l == NULL)
        return 0;
    else
        return l->valor + soma(l->proximo);
}

lista *filtra (lista *l) {
    if (l == NULL)
        return NULL;
    else
        if ((l->valor % 2) == 0) {
			l->proximo = filtra (l->proximo);
			return l;
        }
        else {
            lista *aux = l;
            l = filtra (l->proximo);
            free (aux);
            return l;
        }
}

lista *filtraf (lista *l) {
    if (l == NULL)
        return l;
    else
        if ((l->valor % 2) == 0) {
            lista *aux = (lista *) malloc (sizeof(lista));
            aux->valor = l->valor;
            aux->proximo = filtraf (l->proximo);
            return aux;
        }
        else
            return filtraf (l->proximo);
}

lista *filtrafgen (lista *l, int teste(int)) {
    if (l == NULL)
        return l;
    else
        if (teste(l->valor)) {
            lista *aux = (lista *) malloc (sizeof(lista));
            aux->valor = l->valor;
            aux->proximo = filtrafgen (l->proximo, teste);
            return aux;
        }
        else
            return filtrafgen (l->proximo, teste);
}

int par (int x) {
    return (x % 2) == 0;
}

int impar (int x) {
    return (x % 2) != 0;
}

main() {
	lista *valores = NULL, *valores2 = NULL;
	valores = insere(valores, 1);
	valores = insere(valores, 2);
	valores = insere(valores, 3);
	valores = insere(valores, 4);
	valores2 = filtrafgen(valores, par);
	double soriginal = soma(valores);
	double sfiltrada = soma(valores2);
	printf("%d\n", (int)soriginal);
	printf("%d\n", (int)sfiltrada);
	printf("%f\n", sfiltrada / soriginal);
}

