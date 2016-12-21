valores = [1,2,3,4]
valores2 = [1..4]

soma [] = 0
soma (valor:proximos) = valor + (soma proximos)

filtra [] = []
filtra (valor:proximos)
	| (mod valor 2) == 0 = valor : (filtra proximos)
	| otherwise = filtra proximos

filtragen [] teste = []
filtragen (valor:proximos) teste
	| teste valor = valor : (filtragen proximos teste)
	| otherwise = filtragen proximos teste

par x = (mod x 2) == 0













