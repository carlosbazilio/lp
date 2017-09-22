cpf = [1, 0, 3, 1, 2, 4, 9, 2, 1]

normaliza x
	| (mod x 11) == 10 = 0
	| otherwise = mod x 11

somaprod l1 l2 = foldl (+) 0 (zipWith (*) l1 l2)

calculaDigito l = [normaliza (somaprod l [1..9]), 
                   normaliza (somaprod l [9,8..1])]

