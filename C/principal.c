#include "stdio.h"
#include "string.h"

#define BRASIL 0

int x = 3;
char local[100] = "texto qualquer";

#ifndef BRASIL
char *alo() {
	return "Alo mundo!";
}
#else
char *alo() {
	strcat(local, "Hello world!");
	return local;
}
#endif

int main(int argc, char const *argv[]) {
	printf("%s\n", alo());
	if (x > 0) {
		x--;
		main(argc, argv);
	}
	return 0;
}



