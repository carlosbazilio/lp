function string.starts(String,Start)
   return string.sub(String,1,string.len(Start))==Start
end

codigo = {}
funcoes = {}

arquivo = io.open("exemplo.bazl", "r")

nlinhas = 1;
nfuncoes = 1;

for linha in arquivo:lines() do
	codigo[nlinhas] = linha
	if (string.starts(linha, "func")
		 funcoes[nfuncoes] = linha
		 nfuncoes = nfuncoes + 1
	nlinhas = nlinhas + 1
end

arquivo:close()
	

