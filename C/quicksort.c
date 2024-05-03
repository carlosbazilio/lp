#include "stdio.h"
#include "stdlib.h"

//void swap(int *x, int *y) {
void swap(void **x, void **y) {
   //int temp;
   void *temp;
   temp = *x;
   *x = *y;
   *y = temp;
}

int choose_pivot(int i, int j) {
   return((i+j) /2);
}

//void quicksort(int list[], int m, int n) {
void quicksort(void *list[], int m, int n, int cmp(void *, void *)) {
   //int key,i,j,k;
   void *key; int i,j,k;
   if (m < n)
   {
      k = choose_pivot(m,n);
      swap(&list[m],&list[k]);
      key = list[m];
      i = m+1;
      j = n;
      while(i <= j)
      {
         //while((i <= n) && (list[i] <= key))
         while((i <= n) && (cmp(list[i],key)) <= 0)
                i++;
         //while((j >= m) && (list[j] > key))
         while((j >= m) && (cmp(list[i],key)) > 0)
                j--;
         if( i < j)
                swap(&list[i],&list[j]);
      }
	  // swap two elements
      swap(&list[m],&list[j]);
	  // recursively sort the lesser list
      quicksort(list,m,j-1,cmp);
      quicksort(list,j+1,n,cmp);
   }
}

int cmp_int (void *i, void *j) {
   int ii = *(int *)i;
   int ij = *(int *)j;

   if (ii < ij)
      return -1;
   else
      if (ii > ij)
         return 1;
      else
         return 0;
}

int main(int argc, char const *argv[])
{
   int *v1 = malloc(sizeof(int)); *v1 = 1;
   int *v2 = malloc(sizeof(int)); *v2 = 3;
   int *v3 = malloc(sizeof(int)); *v3 = 2;
   int *valores[] = {v1,v2,v3};
   quicksort(valores, 0, 3, cmp_int);
   for (int i=0; i<=3; i++)
      printf("%d ", *(valores[i]));
   printf("\n");
   return 0;
}
