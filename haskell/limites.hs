
limites l = limites_aux l (maxBound :: Int) (minBound :: Int)

limites_aux [] min max = (min, max)
limites_aux (cabeca : resto) min max
	| cabeca > max && cabeca < min = limites_aux resto cabeca cabeca
	| cabeca < min = limites_aux resto cabeca max
	| cabeca > max = limites_aux resto min cabeca
	| otherwise = limites_aux resto min max

main = print (limites [1, 5, 7, 4, 5, 2, 5, 8 ,9, 123, 432, 23])
