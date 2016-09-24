#include "stdio.h"

typedef struct tsolucao {
	int val[5];
} tsolucao;

tsolucao soma() {
	tsolucao v = {1, 2, 3, 4, 5};
	return v;
}

main() {
	tsolucao w;
	w = soma();
	printf("%d\n", w.val[3]);
}

