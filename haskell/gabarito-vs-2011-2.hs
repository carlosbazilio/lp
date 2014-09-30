-- 3a) Questão

estoque = [(1, "teclado", 50.00, 1), (2, "monitor", 450.00, 1), (3, "tv 54'", 4600.00, 2), (4, "fogao 6 bocas", 1100.00, 2), (5, "laptop", 2000.00, 1)]

tipos = [(1, "informatica"), (2, "eletrodomesticos")]

cod_prod (_, _, _, x) = x
preco_prod (_, _, x, _) = x

produtos cod [] = []
produtos cod (prod:resto)
	| cod_prod prod == cod = prod:(produtos cod resto)
	| otherwise = (produtos cod resto)
	
tipo_prod tp [] = -1
tipo_prod tp ((cod, tipo):resto)
	| tp == tipo = cod
	| otherwise = tipo_prod tp resto

soma_prods tipo = sum [preco_prod(x) | x <- produtos (tipo_prod tipo tipos) estoque]

