def intersecao(lista1, lista2):
	resultado = []
	for x in lista1:
		if x in lista2:
			resultado.append(x)
	return resultado
	
	## return [a for a in lista1 for b in lista2 if a == b]
	## return list(set(lista1) & set(lista2))
	## return list(set(lista1).intersection(lista2))
	## return filter(lambda x : x in lista1, lista2)
	
print(intersecao([1,2,3,4], [2,3,4,5]))
