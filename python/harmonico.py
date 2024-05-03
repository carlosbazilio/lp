def harmonico(inicio, fim, f):
	soma = 0
	for i in range(inicio,fim+1):
		soma = soma + f(i)
	return soma

# Usos:
# harmonico(1,10,lambda(x):x)
# harmonico(1,10,lambda(x):1/x)