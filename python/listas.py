def impar(x):
	return (x % 2) != 0

def impares(lista):
    nova = []
    for i in lista:
        if impar(i):
            nova.append(i)
    return nova

def pares(lista):
    nova = []
    for i in lista:
        if not (impar(i)):
            nova.append(i)
    return nova

def filtra(lista, fteste):
    nova = []
    for i in lista:
        if fteste(i):
            nova.append(i)
    return nova
