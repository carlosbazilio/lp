#include "stdio.h"
#include "stdlib.h"
#include "string.h"

main() {
	char s[] = "carlos (bazilio (martins)";
	char *s2;
	s2 = strtok (s, " ");
	while (s2 != NULL) {
		printf("%s\n", s2);
		s2 = strtok (NULL, " ");
	}
}

