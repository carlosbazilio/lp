#include "stdio.h"
#include "string.h"


int main(int argc, char *argv[]) {
	int i;
	printf("Número de parâmetros: %d\n", argc);
	//int pos = atoi(argv[3]);
	for (i=0; i<argc; i++) {
		printf("Parâmetro %d: %s\n", i, argv[i]);
	}
	//printf("Parâmetro %d: %s\n", pos, argv[pos]);
	return 0;
}

