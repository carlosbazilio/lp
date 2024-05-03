def rodar_esquerda(lista, n):
	n = n % len(lista)
	return lista[n:] + lista[:n]

print(rodar_esquerda("asdfg", 3))
