#include "stdio.h"
#include "stdlib.h"
#include "string.h"

main() {
	char *s = "123", *s2;
	printf("Endereço de s: %d\n", s);
	srand(time(0));
	if ((rand() % 2) == 0)
		s = "bazilio";
	else
		s = "bazilio martins";
	s2 = (char *)alloca(sizeof(char)*7);
	s2 = "carlos";
	//strcat(s2, s);
	s2 = s;
	printf("Endereço de s: %d\n", s);
	printf("%s com tamanho %d\n", s2, (int)(strlen(s2)));
}
