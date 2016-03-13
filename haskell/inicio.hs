fat x 
	| x == 0 = 1 
	| otherwise = x * fat (x - 1)

soma x y = x + y

maximo x y = if x > y then x else y

somaL [] = 0
somaL (cab:corpo) = cab + somaL corpo

maximoL2 [] el = el
maximoL2 (cab:corpo) el = maximoL2 corpo (maximo cab el)

maximoL [] = 0
maximoL (cab:corpo) = maximoL2 corpo cab

impares [] = []
impares (cab:resto)
	| not (odd cab) = impares resto
	| otherwise = cab : (impares resto)

pares [] = []
pares (cab:resto)
	| not (even cab) = pares resto
	| otherwise = cab : (pares resto)

filtra [] p = []
filtra (cab:resto) p
	| not (p cab) = filtra resto p 
	| otherwise = cab : (filtra resto p)




