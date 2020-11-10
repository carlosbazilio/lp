import matplotlib.pyplot as plt

'''
Conteudo exemplo do CSV
====
ano;population
2010;190755799
2011;192379287
2012;193976530
2013;201062789
2014;202799518
2015;204482459
2016;206114067
====
'''

dados = open("populacao-brasileira.csv").readlines()

x = []
y = []

for i in range(1,len(dados)):
	linha = dados[i].split(";")
	x.append(int(linha[0]))
	y.append(int(linha[1]))

plt.plot(x, y, color="black", linestyle="--")
plt.bar(x, y, color="#e4e4e4")
plt.title("Crescimento da Populacao Brasileira, " + str(x[0]) + "-" + str(x[len(x)-1]))
plt.xlabel("Ano")
plt.ylabel("Populacao x10^8")

plt.show()
#plt.savefig("populacao-brasileira.png", dpi=300)

