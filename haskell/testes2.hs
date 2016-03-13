fatorial :: Int -> Int
fatorial 0 = 1
fatorial n = fatorial(n-1) * n

fatorial2 0 = 1
fatorial2 n = fatorial2(n-1) * n

mult x y = x * y
f = mult 2

soma (cab:resto) = cab + soma resto
soma [] = 0

filtra [] f = []
filtra (cab:resto) f =
	if (f cab)
	then cab:(filtra resto f)
	else (filtra resto f)

grande s = (length s) > 5

mult3 [] = 0
mult3 (cab:corpo) = (mult3' cab) + (mult3 corpo)
mult3' (a,b) = a*b











