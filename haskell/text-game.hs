comodos "sala-estar" = "Voce esta na sala de estar"
comodos "jardim" = "Voce esta num lindo jardim"
comodos "sotao" = "Voce esta no sotao"

caminhos "sala-estar" = [("jardim", "esquerda", "porta"), ("sotao", "acima", "escada")]
caminhos "jardim" = [("sala-estar", "direita", "porta")]
caminhos "sotao" = [("sala-estar", "abaixo", "escada")]

descrever_caminho (destino, orientacao, meio) = "Ha um(a) " ++ meio ++ " indo " ++ orientacao ++ " daqui"

descrever_caminhos local = map descrever_caminho (caminhos local)

procura_destino local_atual direcao_desejada modo [] = ""
procura_destino local_atual direcao_desejada modo ((destino, direcao, meio):alternativas)
	| ((direcao_desejada == direcao) && (modo == meio)) = destino
	| otherwise = procura_destino local_atual direcao_desejada modo alternativas

ir local direcao meio = procura_destino local direcao meio (caminhos local)

play = loop "jardim"
loop corrente = do
	let proximo = getLine
	loop proximo

main = print (ir "jardim" "direita" "porta")
