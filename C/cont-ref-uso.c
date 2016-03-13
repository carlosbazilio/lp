#include "contref.h"
// Declaração das funções malloc2, atrib, atrib2 e dump

main() {
	int *v,  *w;

	v = malloc2(int); // Aloca espaço dinâmico para v
	v = atrib(10); // Atribui 10 a área alocada 
	printf ("v: %d\n", v);
	dump(); // Imprime estado da memória
	w = malloc2(int);
	w = atrib(20);
	printf ("w: %d\n", w);
	dump();
	v = atrib2(w); // v = w
	dump();
	v = atrib2(NULL);
	dump();
}

