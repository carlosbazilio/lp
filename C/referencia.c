#include "stdio.h"
#include "stdlib.h"

typedef struct t {
	int c1;
	float c2;
	char c3[10];
} t;

void g(int p) {
	p = p + 1;
	printf("Dentro de g: %d\n", p);
}

void f() {
	int x = 10;
	g(x);
	printf("Dentro de f: %d\n", x);
}

void h(t *param) {
	param->c2 = 50.0;
	printf("%d, %f, %s\n", param->c1, param->c2, param->c3);
}

void h2(t &param) {
	param.c2 = 45.0;
}

void h3(t param) {
	param.c2 = 45.0;
}

void h4(int v[3]) {
	for (int i=0; i<3; i++)
		v[i] = i;
}

int main() {
	//f();
	/*t t1 = {1, 10.5, "xuxa"};
	t t2 = {2, 20.8, "mareana"};
	t t3;
	t3 = t1;
	h2(t3);
	h(&t3);
	
	t t2 = {1, 20.9, "macae"};
	h (&t2);
	printf("%d, %f, %s\n", t2.c1, t2.c2, t2.c3);*/
	
	int vetor[] = {0, 0, 0};
	h4(vetor);

	for (int i=0;i<3;i++)
		printf("%d ", vetor[i]);
	printf("\n");

	return 0;
}
