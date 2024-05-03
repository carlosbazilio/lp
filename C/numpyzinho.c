#include "stdio.h"
#include "stdlib.h"

#define TAM 3

typedef struct tipo_gen {
	void * data;
	void (* add)(void *, void *);
	void (* print)(void *);
} tipo_gen;

tipo_gen valores[100];

tipo_gen *aloca_tipo_gen(void *valor, 
	                     void soma (void *, void *),
	                     void imprime (void *)) {
	tipo_gen *valor_gen = malloc(sizeof(tipo_gen));
	valor_gen->data = valor;
	valor_gen->add = soma;
	valor_gen->print = imprime;
	return valor_gen;
}

void soma_valor(void *s, void *v) {
	tipo_gen *self = s;
	double *dself = self->data;
	double *dv = v;
	*dself = *dself + *dv;
}

void imprime_valor(void *s) {
	tipo_gen *self = s;
	double *dself = self->data;
	printf("%g\n", *dself);
}

void soma_vetor(void *s, void *v) {
	tipo_gen *self = s;
	double *dself = self->data;
	double *dv = v;
	for (int i=0; i<TAM; i++)
		dself[i] = dself[i] + dv[i];
}

void imprime_vetor(void *s) {
	tipo_gen *self = s;
	double *dself = self->data;
	for (int i=0; i<TAM; i++)
		printf("%g ", dself[i]);
	printf("\n");
}

int main(int argc, char const *argv[]) {
	double *a, *b;
	a = malloc(sizeof(double));
	*a = 10;
	b = malloc(sizeof(double));
	*b = 20;
	tipo_gen *val_gen;
	
	val_gen = aloca_tipo_gen(a, soma_valor, imprime_valor);
	val_gen->add(val_gen, b);

	val_gen->print(val_gen);

	double veta[] = {[0 ... TAM] = 0};
	double vetb[] = {[0 ... TAM] = 10};
	
	val_gen = aloca_tipo_gen(veta, soma_vetor, imprime_vetor);
	val_gen->add(val_gen, vetb);

	val_gen->print(val_gen);

	return 0;
}
