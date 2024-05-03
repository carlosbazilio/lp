#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>

#define HEAP_SIZE 80

typedef struct  elemento
{
    char id;
    int tamanho;
    int ini;
}elemento;

typedef struct listaElementos
{
    elemento *obj;
    struct listaElementos *prox;
}listaElementos;

void Inicializar(bool *heap);
void Imprimir(bool *heap, listaElementos *lista, bool *heapLixo);
void ModoHeap(char *metodo);
void Adicionar(char id, int tamanho, bool *heap, listaElementos **lista);
void Deletar(char id, bool *heap, listaElementos **lista);
void Atribuir(elemento *a, elemento *b, bool *heapLixo);
void *DestroiLista(listaElementos *lista);
void Interpretar(bool *heap, bool *heapLixo, listaElementos **lista);

int ind = 0;
int cont = 0;
int modo = 0;


int main()
{
    setlocale(LC_CTYPE, "Portuguese");
    
    bool heap[HEAP_SIZE];
    bool heapLixo[HEAP_SIZE];
    listaElementos *lista = NULL;
    Inicializar(heap);
    Inicializar(heapLixo);
    
    while(cont == 0)
    {
        Interpretar(heap, heapLixo, &lista);
    }
    lista = DestroiLista(lista);
}

elemento *CriaElemento(char id, int tamanho)
{
    elemento *new = (elemento*) malloc(sizeof(elemento));
    new->id = id;
    new->tamanho = tamanho;
    new->ini = -1;

    return new;
}
void Inicializar(bool *heap)
{
    for(int i = 0; i < HEAP_SIZE; i++)
        heap[i] = false;   
}
void SetCor(int style)
{
  switch (style)
  {
  case 0:
    printf("\x1b[0m");
    break;
  case 1:
    printf("\x1b[37;100m");
    break;
  case 2:
    printf("\x1b[30;42m");
    break;
  case 3:
    printf("\x1b[30;41m");
    break;
  }
}
void Imprimir(bool *heap, listaElementos *lista, bool *heapLixo)
{
    printf("\n");
    for(int i = 0; i < HEAP_SIZE; i++)
    {
        if(i != 0 && i % 20 == 0)
            printf("\n");
        if(heap[i])
            SetCor(2);
        else
            SetCor(1);
        if(heapLixo[i])
            SetCor(3);
        printf("%3d  ", i);
        SetCor(0);
    }
    printf("\n");
    while(lista != NULL)
    {
        elemento *obj = lista->obj;
        printf("%c %d - %d\n", obj->id, obj->ini, obj->ini + obj->tamanho - 1);
        lista = lista->prox;
    }
}
void ModoHeap(char *metodo)
{
    if(strcmp(metodo, "next") == 0)
    {
        modo = 1;
        printf("\nHeap usando método Next-fit\n");
    }
    else if(strcmp(metodo, "first") == 0)
    {
        modo = 0;
        ind = 0;
        printf("\nHeap usando método First-fit\n");
    }else
        printf("\nArgumento %c%s%c não reconhecido\n", 34, metodo, 34);
}
void AdicionarNaLista(elemento *obj, listaElementos **lista)
{
    listaElementos *new = (listaElementos*) malloc(sizeof(listaElementos));
    new->obj = obj;
    new->prox = NULL;
    if(*lista == NULL)
        *lista = new;
    else
    {
        listaElementos *aux = *lista;
        while(aux->prox != NULL)
            aux = aux->prox;
        aux->prox = new;
    }
}
listaElementos *RemoverDaLista(elemento *obj, listaElementos *lista)
{
    if(lista->obj == obj)
    {
        listaElementos *aux = lista->prox;
        free(lista->obj);
        free(lista);
        return aux;
    }else
        lista->prox = RemoverDaLista(obj, lista->prox);
        return lista;
}
void Adicionar(char id, int tamanho, bool *heap, listaElementos **lista)
{
    elemento *obj = CriaElemento(id, tamanho);
    int i;
    if(modo == 1)
        i = ind;
    else
        i = 0;

    int ini = -1;
    while(i < HEAP_SIZE && ini == -1)
    {
        if(heap[i] == false && i + obj->tamanho <= HEAP_SIZE)
        {
            bool test = false;
            int j = i;
            for(; i - j < obj->tamanho; i++)
                test = test || heap[i];
            if(!test)
                ini = j;
        }
        i++;
    }
    if(ini != -1)
    {
        for(int j = 0; j < obj->tamanho; j++)
            heap[ini + j] = true;
        obj->ini = ini;
        ind = ini + obj->tamanho;
        AdicionarNaLista(obj, lista);
    }else
        printf("\nSem espaço suficiente no heap.\n");
}
void Deletar(char id, bool *heap, listaElementos **lista)
{
    listaElementos *aux = *lista;
    while(aux != NULL && aux->obj->id != id)
        aux = aux->prox;
    if(aux != NULL)
    {
        for(int i = aux->obj->ini; i < aux->obj->ini + aux->obj->tamanho; i++)
            heap[i] = false;
        int ini = aux->obj->ini;
        *lista = RemoverDaLista(aux->obj, *lista);
        aux = *lista;
        while(aux != NULL)
        {
            if(aux->obj->ini == ini)
            {
                *lista = RemoverDaLista(aux->obj, *lista);
                aux = *lista;
            }else
                aux = aux->prox;
        }
    }else
        printf("\nElemento não encontrado no heap.\n");
}
void Atribuir(elemento *a, elemento *b, bool *heapLixo)
{
    if(a != b)
    {
        for(int i = 0; i < a->tamanho; i++)
        {
            heapLixo[i + a->ini] = true;
        }
        a->ini = b->ini;
        a->tamanho = b->tamanho;
    }
}
void *DestroiLista(listaElementos *lista)
{
    if(lista != NULL)
    {
        listaElementos *aux = lista->prox;
        free(lista->obj);
        free(lista);
        return DestroiLista(aux);
    }
    return NULL;
}
void Interpretar(bool *heap, bool *heapLixo, listaElementos **lista)
{
    char cmd[15];
    char aux[15];
    listaElementos *auxlista = *lista;

    printf("\n> ");
    fgets(cmd, 15, stdin);
    cmd[strlen(cmd) - 1] = '\0';

    int j;
    for(j = 0; cmd[j] != ' ' && cmd[j] != '\0'; j++)
        aux[j] = cmd[j];
    aux[j] = '\0';

    if(strcmp(aux, "new") == 0)
    {
        j++;
        char id = cmd[j];
        while(auxlista != NULL && auxlista->obj->id != id)
            auxlista = auxlista->prox;
        if(auxlista == NULL)
        {
            while(cmd[j] != ' ' && cmd[j] != '\0')
                j++;
            j++;
            int i;
            for(i = 0; cmd[j + i] != '\0'; i++)
                aux[i] = cmd[j + i];
            aux[i] = '\0';
            int tamanho = atoi(aux);
            if(tamanho == 0)
                printf("\nTamanho inválido\n");
            else
                Adicionar(id, tamanho, heap, lista);
        }else
            printf("\nElemento %c%c%c já existe\n", 34, id, 34);
    }else if (strcmp(aux, "heap") == 0)
    {
        j++;
        int i;
        for(i = 0; cmd[j + i] != '\0'; i++)
            aux[i] = cmd[j + i];
        aux[i] = '\0';
        ModoHeap(aux);
    }else if (strcmp(aux, "exibe") == 0)
        Imprimir(heap, *lista, heapLixo);
    else if (strcmp(aux, "del") == 0)
    {
        j++;
        char id = cmd[j];
        Deletar(id, heap, lista);
    }else if(cmd[j + 1] == '=')
    {
        char *par2 = cmd + j + 3;
        elemento *a = NULL, *b = NULL;
        while(auxlista != NULL)
        {
            if(auxlista->obj->id == aux[0])
                a = auxlista->obj;
            if(auxlista->obj->id == par2[0])
                b = auxlista->obj;
            auxlista = auxlista->prox;
        }
        if(a == NULL)
            printf("\nElemento %c%c%c não econtrado\n", 34, aux[0], 34);
        if(b == NULL)
            printf("\nElemento %c%c%c não econtrado\n", 34, par2[0], 34);
        if(a != NULL && b != NULL)
            Atribuir(a, b, heapLixo);
    }else if(strcmp(aux, "exit") == 0)
    {
        cont = 1;
        printf("\n");
    }else
    {
        if(strlen(aux) != 0)
        printf("\nComando %c%s%c não reconhecido\n", 34, aux, 34);
    }
}