
--4)
somaLista [] = 0
somaLista ((_,_,preco):resto) =
	preco + (somaLista resto)

preco (_,_,p) = p
somaLista' l = foldl (\x y -> x + (preco y)) 0 l
ou
somaLista' l = foldr (\x y -> (preco x) + y) 0 l
ou
somaLista' l = foldr (\x y -> (let preco' = \(_,_,p) -> p in (preco' x) + y)) 0 l