// (*(f(a)+3))->b[c] = 2;

#include <stdio.h>

typedef struct estranha {
	int b[100];
} testranha;

testranha vglobal[100];

testranha *f(int x) {
	return &vglobal[x];
}

int main(int argc, char const *argv[])
{
	int c = 0, a = 0;
	(*(f(a)+3)).b[c] = 2;
	printf("%d\n", vglobal[3].b[0]);
	return 0;
}


