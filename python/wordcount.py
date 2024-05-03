from functools import reduce

def pertence(x, lista):
	for (z,w) in lista:
		if x == z:
			return True
	return False

def wordcountfrase(frase):
	palavras = frase.lower().split()
	saida = []
	for palavra in palavras:
		if not pertence(palavra, saida):
			qtd = len(list(filter(lambda x : x == palavra, palavras)))
			saida.append((palavra, qtd))
	return saida

def wordcount(frases):
	termos = map(wordcountfrase, frases)
	termos = reduce(lambda x, y : x + y, termos)
	saida = []
	i = 0
	while len(termos) > 0:
		repetidos = filter(lambda z : z[0] == termos[i][0], termos)
		saida.append(reduce(lambda k, w : (k[0],k[1]+w[1]),repetidos))
		termos = list(filter(lambda z : z[0] != termos[i][0], termos))
	return saida

