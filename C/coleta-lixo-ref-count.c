#include "stdio.h"
#include "stdlib.h"

typedef struct celula {
	int count;
	void *info;
} tcelula;

tcelula *heap [1000];
int posHeap = 0;

void *aloca (int size) {
	tcelula *area = (tcelula *)malloc(sizeof(int) + sizeof(void *));
	area->count = 1;
	heap[posHeap] = area;
	posHeap++;
	void *pInfo = malloc(size);
	area->info = pInfo;
	return area->info;
}

void adiciona (void *p, int v) {
	for (int i=0; i<posHeap; i++)
		if (p == heap[i]->info) {
			heap[i]->count += v;
			if (heap[i]->count == 0) {
				free(heap[i]->info);
				free(heap[i]);
				heap[i] = NULL;
			}
			break;
		}
}

void atribui (void **left, void **right) {
	adiciona (left, -1);
	*left = *right;
	adiciona (right, +1);
}

void atribui_valor (void **left, int valor) {
	*((int *)(*left)) = valor;
}

int main() {
	void *i = aloca(sizeof(int));
	void *j = aloca(sizeof(int));
	atribui (&j, &i);
	atribui_valor (&i, 10);
	printf("%d\n", *(int *)j);
	return 0;
}
