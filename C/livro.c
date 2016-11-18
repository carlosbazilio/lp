#include "stdio.h"
#define TAMANHO_ACERVO 1000

typedef struct livro
{
	char titulo[100];
	char autor[50];
	char editora[20];
	int num_paginas;
} livro;

void imprimeAcervo(livro valores[], int n) {
	int i;
	for (i=0; i<n; i++)
		printf("%s, %s, %s, %d\n", valores[i].titulo, valores[i].autor, valores[i].editora, valores[i].num_paginas);
}

int contaPaginasAcervo(livro valores[], int n) {
	int i; int paginas = 0;
	for (i=0; i<n; i++)
		paginas += valores[i].num_paginas;
	return paginas;
}

main() {
	livro acervo[TAMANHO_ACERVO];
	int num_livros = 0;

	livro ctotal = {"C Total e Completo", "Eber Schimidt", "LTC", 800};
	livro enigmado8 = {"Enigma do 8", "Katherine Neville", "Rocco", 678};

	acervo[num_livros++] = ctotal;
	acervo[num_livros++] = enigmado8;
		
	// printf("%s, %s, %s, %d\n", ctotal.titulo, ctotal.autor, ctotal.editora, ctotal.num_paginas);
	// printf("%s, %s, %s, %d\n", enigmado8.titulo, enigmado8.autor, enigmado8.editora, enigmado8.num_paginas);

	imprimeAcervo(acervo, num_livros);

	printf("Quantidade de paginas: %d\n", contaPaginasAcervo(acervo, num_livros));
}

