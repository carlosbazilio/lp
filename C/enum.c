#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct cidade {
	int codigo;
	char nome[20];
	int ddd;
	char estado[3];
} tcidade;

enum cidades {Rio, Brasilia, Belem, Manaus, BoaVista, Teresina, Fortaleza, Natal};

// #define Rio 0
// #define Brasilia 1
// #define Belem 2
// ...

tcidade *cidades_base[8];

int main(int argc, char const *argv[])
{
	cidades_base[Belem] = (tcidade *)malloc(sizeof(tcidade));
	strcpy(cidades_base[Belem]->nome, "Belém");
	strcpy(cidades_base[Belem]->estado, "PA");

	printf("Cidade %s-%s, código %d\n", cidades_base[Belem]->nome, 
		                                cidades_base[Belem]->estado, 
		                                Belem);

	cidades_base[BoaVista]

	free(cidades_base[Belem]);

	return 0;
}

