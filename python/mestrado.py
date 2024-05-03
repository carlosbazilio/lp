produtos = [("televisor", "eletro", 500), ("notebook", "informatica", 3000), ("geladeira", "cozinha", 2500), ("fogao", "cozinha", 750)]

colunas = { "nome" : 0, "categoria" : 1, "preco" : 2 }

def categorias(lista):
	#lista_cat = []
	#for p in lista:
	#	lista_cat.append(p[1])
	#return lista_cat
	return map(lambda x : x[1], lista)

def valores(lista, campo):
	return map(lambda x : x[colunas[campo]], lista)


print (valores(produtos, "preco"))

