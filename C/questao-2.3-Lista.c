#include "stdio.h"

typedef struct ponto { int x; int y; int z; } ponto;

void imprimePonto (ponto *p) {
	printf("(%d,%d,%d)\n", p->x, p->y, p->z);
}

int main() {
	int i;
	void (* v[2])(ponto *);
	v[0] = imprimePonto;
	v[1] = NULL;
 	ponto figura[1] = {{0,0,0}};
	for (i=0; v[i]!=NULL; i++) {
		v[i](figura);
	}
}

