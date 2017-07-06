-- 2)
frases = ["A culpa é minha, eu coloco ela em quem eu quiser.","Se alguma coisa está difícil de ser feita, é porque não é para ser feita","É melhor ver coisas do que fazer coisas.","A tentativa é o primeiro passo para o fracasso."]

-- a)
linhas t = length t
-- b)
caracteres t = foldl (\x y -> x + (length y)) 0 t
-- c)
nao_nulo c = c /= ' '
caracteres_nao_nulos t = caracteres (map (filter nao_nulo) t)
-- d)


-- 4)
somaLista [] = 0
somaLista ((_,_,preco):resto) =
	preco + (somaLista resto)

preco (_,_,p) = p
somaLista' l = foldl (\x y -> x + (preco y)) 0 l
-- ou
-- somaLista' l = foldr (\x y -> (preco x) + y) 0 l
-- ou
-- somaLista' l = foldr (\x y -> (let preco' = \(_,_,p) -> p in (preco' x) + y)) 0 l