soma [] = 0
soma (cab:resto) = 
    cab + soma resto

impares [] = []
impares (cab:resto)
    | (mod cab 2) /= 0 = 
        cab : (impares resto)
    | otherwise = impares resto

pares [] = []
pares (cab:resto)
    | (mod cab 2) == 0 = 
        cab : (pares resto)
    | otherwise = pares resto

par v = (mod v 2) == 0
impar v = (mod v 2) /= 0
natural v = v >= 0

filtra [] _ = []
filtra (cab:resto) teste
    | teste cab = 
        cab : (filtra resto teste)
    | otherwise = filtra resto teste

reduce f base [] = base
reduce f base (cab:corpo) =
    reduce f (f base cab) corpo

-- > reduce (\x y -> x + y) 0 [1..5]
-- 15
-- > reduce (\x y -> x ++ [y]) [] [1..5]
-- [1,2,3,4,5]
-- "linguagens de programação"
-- > reduce (\x y -> x ++ [y]) [] ["linguagens", "de", "programação"]
-- "linguagens de programação"

-- quadrado :: Int -> Int
quadrado n = n * n

soman x y = x + y


produto [] [] = 0
produto (cab1:resto1) (cab2:resto2) = (cab1 * cab2) + produto resto1 resto2

produtol [] [] = []
produtol (cab1:resto1) (cab2:resto2) = (cab1 * cab2) : produtol resto1 resto2

produtos = [(1, "teclado", 50.00), (2, "monitor", 450.00), (3, "tv 54'", 4600.00), (4, "fogao 6 bocas", 1100.00), (5, "laptop", 2000.00)]

retornaProduto cod [] = (0,"",0.0)
retornaProduto cod ((ident, nome, preco):resto)
    | cod == ident = (ident, nome, preco)
    | otherwise = retornaProduto cod resto

preco (_, _, p) = p

retornaPreco cod estoque = preco (retornaProduto cod estoque)

checkout carrinho estoque =
    foldl (\x (cod, qtd) -> x + (retornaPreco cod estoque) * qtd) 0 carrinho


repeticao [] = []
repeticao valores = repeticao_aux valores 1

repeticao_aux [] contador = []
repeticao_aux (cab:resto) contador =
    (gera_repeticao cab contador) ++ (repeticao_aux resto (contador+1))

gera_repeticao carac 0 = []
gera_repeticao carac x = carac : (gera_repeticao carac (x-1))
