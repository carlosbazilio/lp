def merge(lista1, lista2):
	i1 = 0
	i2 = 0
	resultado = []
	while (i1 < len(lista1) and i2 < len(lista2)):
		if (lista1[i1] <= lista2[i2]):
			resultado.append(lista1[i1])
			i1=i1+1
		else:
			resultado.append(lista2[i2])
			i2=i2+1
	if i1 < len(lista1):
		resto = lista1[i1:]
	else:
		resto = lista2[i2:]

	return resultado + resto

	## return sorted (lista1 + lista2)
	
print(merge([1,2,3,4], [2,3,4,5]))
