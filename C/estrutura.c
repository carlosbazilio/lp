#include "stdio.h"
#include "stdlib.h"
#include "string.h"

typedef struct t {
	int c1;
	float c2;
	char *c3;
} t;

void f(t *pt) {
	pt->c3 = "stefan";
}

main() {
	t t1 = {1, 10.5, "xuxa"};
	t t2 = {2, 20.8, "mareana"};
	t t3 = t1;
	//f(&t3);
	printf("%s com tamanho %d\n", t3.c3, (int)(strlen(t3.c3)));
}
