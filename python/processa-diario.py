import sys

dados = open(sys.argv[1],"r")
matriculas = open(sys.argv[2],"w")
nomes = open(sys.argv[3],"w")

num_linhas = sum(1 for linha in open(sys.argv[1]))

while num_linhas > 0:
	linha = dados.readline()
	if len(linha) == 10: # Tamanho do campo matricula
		matriculas.write(linha)
	if len(linha) > 10: # Campo nome
		nomes.write(linha)
	num_linhas = num_linhas - 1

dados.close()
matriculas.close()
nomes.close()
