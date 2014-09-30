meta_estoque = ["cod", "nome", "preco", "cod_tipo"]

estoque = [(1, "teclado", 50.00, 1), (2, "monitor", 450.00, 1), (3, "tv 54'", 4600.00, 2), (4, "fogao 6 bocas", 1100.00, 2), (5, "laptop", 2000.00, 1)]

meta_tipos = ["cod", "nome"]

tipos = [(1, "informatica"), (2, "eletrodomesticos")]

cod_prod (_, _, _, x) = x
preco_prod (_, _, x, _) = x

pos termo [] = 0
pos termo termos = pos_aux termo termos 1
pos_aux termo (cab:resto) indice
	| termo == cab = indice
	| otherwise = pos_aux termo resto (indice + 1)
	
elemento 1 (x, _, _, _) = x
elemento 2 (_, x, _, _) = x
elemento 3 (_, _, x, _) = x
elemento 4 (_, _, _, x) = x

select campo [] = []
select campo (cab:resto) =
	filtra estoque (pos campo meta_estoque)
	
filtra [] _ = []
filtra (cab:resto) n =
	(elemento n cab):(filtra resto n)

produtos cod [] = []
produtos cod (prod:resto)
	| cod_prod prod == cod = prod:(produtos cod resto)
	| otherwise = (produtos cod resto)
	
tipo_prod tp [] = -1
tipo_prod tp ((cod, tipo):resto)
	| tp == tipo = cod
	| otherwise = tipo_prod tp resto

soma_prods tipo = sum [preco_prod(x) | x <- produtos (tipo_prod tipo tipos) estoque]

