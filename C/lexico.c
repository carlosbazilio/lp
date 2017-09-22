#include "stdio.h"
#include "string.h"

#define MAX_PALAVRA 100

char *reservadas[] = {"class", "inherits", "if", "then", "else", "fi", 
"while", "loop", "pool", "let", "in", "case", "of", "esac", 
"new", "isvoid", "not", "true", "false", ""};

void ler_palavra(int *posicao, char entrada[], char *palavra) {
	int i = 0;
	palavra[i] = '\0';
	while ((entrada[*posicao] >= 'a' && entrada[*posicao] <= 'z') ||
		   (entrada[*posicao] >= 'A' && entrada[*posicao] <= 'Z') ||
		   (entrada[*posicao] >= '0' && entrada[*posicao] <= '9') ||
		   (entrada[*posicao] == '_')) {
		palavra[i] = entrada[*posicao];
		(*posicao)++; i++;
	}
	palavra[i] = '\0';
}

int ehPalavraReservada (char *palavra) {
	int i, tam;
	for (i = 0; strlen(reservadas[i]) > 0; i++) {
		if (strcmp(palavra, reservadas[i]) == 0)
			return 1;
	}
	return 0;
}

int main(int argc, char *argv[])
{
	int posicao_leitura = 0;
	char *codigo = argv[1];
	char palavra[MAX_PALAVRA];

	while (codigo[posicao_leitura] != '\0') {
		switch (codigo[posicao_leitura]) {
			case 'a'...'z':
			case 'A'...'Z':
			case '_':
				ler_palavra(&posicao_leitura, codigo, palavra);
				if (ehPalavraReservada(palavra)) {
					printf("Palavra reservada: %s\n", palavra);
				}
				else {
					printf("Identificador: %s\n", palavra);
				}
			break;
			case ' ':
			case '\t':
			case '\n':
				posicao_leitura++;
			break;
			default:
				printf("Não identificado: %c\n", codigo[posicao_leitura]);
				posicao_leitura++;
			break;
		}
	}

	return 0;
}

