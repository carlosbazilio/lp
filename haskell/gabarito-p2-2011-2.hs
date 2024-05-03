import Data.Char

-- 2a) Questão

-- a)
fib 1 = 0
fib 2 = 1
-- fib n = fib (n - 1) + fib (n - 2)
fib n = fib_aux 0 1 n

fib_aux ant curr n
	| n == 3 = ant + curr
	| otherwise = fib_aux curr (ant + curr) (n - 1)

-- b)
sublista 0 0 _ = []
sublista i j (cab : resto)
	| i > j = []
	| i == 1 && j == 1 = [cab]
	| i == 1 && j > 1 = cab : sublista i (j - 1) resto
	| i > 1 = sublista (i - 1) (j - 1) resto

-- c)
insere_pos el 1 [] = [el]
insere_pos el pos (cab:lista)
	| pos <= 0 = cab:lista
	| pos == 1 = el:cab:lista
	| otherwise = cab : (insere_pos el (pos - 1) lista)
	
-- d)
comprime [] = []
comprime (caracter:resto) =
	comprime_aux caracter 1 resto
	
comprime_aux anterior qtd []
	| qtd < 4 = repete anterior qtd
	| otherwise = '!':(intToDigit qtd):[anterior]
comprime_aux anterior qtd (cab:resto)
	| anterior == cab = comprime_aux cab (qtd + 1) resto
	| qtd > 3 = '!':(intToDigit qtd):anterior:(comprime_aux cab 1 resto)
	| otherwise = (repete anterior qtd) ++ (comprime_aux cab 1 resto)
	
repete caracter 1 = [caracter]
repete caracter qtd = caracter:(repete caracter (qtd - 1))

-- e)
-- super_f 1 [(3 +), (2 *), \ x -> x * x] = 64
super_f n [] = n
super_f n (f:resto) = super_f (f n) resto

-- f)
quadrados = take 50 [x * x | x <- [1 ..], even x]


-- 3a) Questão

produtos = [(1, "teclado", 50.00), (2, "monitor", 450.00), (3, "tv 54'", 4600.00), (4, "fogao 6 bocas", 1100.00), (5, "laptop", 2000.00)]

-- a)
produto cod [] = (0, "", 0)
produto cod ((c, p, v):resto) 
	| c == cod = (c, p, v)
	| otherwise = produto cod resto 

-- b)
valor [] _ = 0
valor ((cod, qtd) : resto_carrinho) estoque =
	(preco (produto cod estoque) * qtd) + (valor resto_carrinho estoque)

valor' carrinho estoque = foldl (+) 0 (map (\(cod, qtd) -> preco (produto cod estoque) * qtd) carrinho)
	
preco (_, _, v) = v
