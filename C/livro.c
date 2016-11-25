#include "stdio.h"
#define TAMANHO_ACERVO 1000

typedef struct livro
{
	char titulo[100];
	char autor[50];
	char editora[20];
	int num_paginas;
} livro;

typedef struct acervo
{
	livro livros[TAMANHO_ACERVO];
	int num_livros;
} acervo;

void adicionaLivro(acervo *valores, livro l) {
	valores->livros[valores->num_livros] = l;
	valores->num_livros++;
}

void imprimeAcervo(acervo valores) {
	int i;
	for (i=0; i<valores.num_livros; i++)
		printf("%s, %s, %s, %d\n", valores.livros[i].titulo, 
			                       valores.livros[i].autor, 
			                       valores.livros[i].editora, 
			                       valores.livros[i].num_paginas);
}

int contaPaginasAcervo(acervo valores) {
	int i; int paginas = 0;
	for (i=0; i<valores.num_livros; i++)
		paginas += valores.livros[i].num_paginas;
	return paginas;
}

main() {
	acervo meus_livros;
	meus_livros.num_livros = 0;

	livro ctotal = {"C Total e Completo", "Eber Schimidt", "LTC", 800};
	livro enigmado8 = {"Enigma do 8", "Katherine Neville", "Rocco", 678};

	//meus_livros.livros[meus_livros.num_livros++] = ctotal;
	//meus_livros.livros[meus_livros.num_livros++] = enigmado8;
	adicionaLivro(&meus_livros, ctotal);
	adicionaLivro(&meus_livros, enigmado8);
	//meus_livros.livros[-1] = ctotal;
		
	// printf("%s, %s, %s, %d\n", ctotal.titulo, ctotal.autor, ctotal.editora, ctotal.num_paginas);
	// printf("%s, %s, %s, %d\n", enigmado8.titulo, enigmado8.autor, enigmado8.editora, enigmado8.num_paginas);

	imprimeAcervo(meus_livros);

	printf("Quantidade de paginas: %d\n", contaPaginasAcervo(meus_livros));
}

