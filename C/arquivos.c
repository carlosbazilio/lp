#include "stdio.h"
#include "stdlib.h"
#include "string.h"

char *retornaNomeFuncao (char *linha) {
	char *delim = " (\t,)";
	char *s = strtok(linha, delim);
	while (strcmp(s, "func") != 0) {
		s = strtok(NULL, delim);
	}
	return strtok(NULL, delim);
}

main(int argc, char *argv[]) {
	char linha[100];
	char codigo[1000][100];
	if (argc > 1) {
		FILE *fp = fopen(argv[1], "rt");
		if (fp != NULL) {
			while (!feof(fp)) {
				//fscanf(fp, "%80[^\n]", linha);
				fgets(linha, 80, fp);
				printf("%s", linha);
				if (strstr(linha, "func ")) {
					printf("O nome da função é: %s\n", retornaNomeFuncao(linha));
				}
			}
			fclose(fp);
		}
	}
}

