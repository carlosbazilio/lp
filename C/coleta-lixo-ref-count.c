#include "stdio.h"
#include "stdlib.h"

typedef struct celula {
	int count;
	void *info;
} tcelula;

void *aloca (int size) {
	tcelula *area = (tcelula *)malloc(sizeof(int) + sizeof(void *));
	area->count = 0;
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

void atribui (voids *left, void *right) {
	adiciona (left, -1);
	*left = *right;
	adiciona (right, +1);
}


tcelula *heap [1000];
int posHeap = 0;

main() {
	int *i = (int *)aloca(sizeof(int));
	int *j;
	atribui (j, i);
}
