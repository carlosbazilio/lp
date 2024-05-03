#include "contref.h"
#include "stdio.h"

struct new_int {
	int valor;
	int contador;
}

new_malloc(new_int **lado_esq) {
	*lado_esq = (new_int *) malloc (sizeof(new_int));
}

new_assign(new_int **lado_esq,
           new_int *lado_dir) {
    if (lado_dir == NULL) {
    	if (lado_esq->contador-1 == 0)
    		free (*lado_esq);
    	else
    		(*lado_esq)->contador--;
    }
	*lado_esq = lado_dir;
}

main() {
	new_int *v, *w, *k;
	new_malloc(&v);
	new_malloc(&w);
	new_assign(&k, v);
	new_assign(&v, NULL);
}