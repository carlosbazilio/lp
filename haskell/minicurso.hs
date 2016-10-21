--------
-- Expressividade de Haskell (Compare com código em C)
a = [2, 4..100]
b = drop 5 a


--------
-- Funções Exemplo
--h0 = let inf = 1; sup = 100 in
--	if (inf > sup) then 0 
--	   else if (inf == sup) then 1/inf 
--	   	  else (1/inf) + (h0 (inf + 1) sup)

-- maximo
--maximo :: Int -> Int -> Int
maximo a b = if a > b then a else b
-- Salientar que o if também é uma função!

maximo' a b
	| a > b = a
	| otherwise = b


-- Fatorial
fat 0 = 1
fat n = n * fat (n-1)

--comb :: Int -> Int -> Int
comb n p = fat n / ((fat p) * (fat (n-p)))

-- h
h inf sup = 
	if (inf > sup) then 0 
	   else if (inf == sup) then 1/inf 
	   	  else (1/inf) + (h (inf + 1) sup)

h1 inf sup
	| inf > sup = 0 
	| inf == sup = 1/inf 
	| otherwise = (1/inf) + (h1 (inf + 1) sup)

--------
-- Valores de 1a classe
-- Atribuição a variáveis
harm = h1

-- Passagem de parâmetros
h2 f inf sup
	| inf > sup = 0 
	| inf == sup = f inf 
	| otherwise = (f inf) + (h2 f (inf + 1) sup)

razao x = 1 / x

ident x = x

--------
-- Funções puras
g = 10
f x = x * x
--g = g + 1
f2 = g * g

-- !!!! Intervalo !!!!

--------
-- Listas
dias_semana = [1, 2, 3, 4, 5, 6, 7]
dias_semana1 = [1..7]
dias_semana2 = ["segunda", "terca", "quarta", "quinta", "sexta", "sabado", "domingo"]

-- No prompt
--let cab:resto = dias_semana
--cab
--resto
--let nova = 0:dias_semana
--nova
--dias_semana

soma [] = 0
soma lista = (head lista) + (soma (tail lista))

soma2 [] = 0
soma2 (cab:corpo) = cab + (soma2 corpo)

impares [] = []
impares (cab:corpo)
	| odd cab = cab:(impares corpo)
	| otherwise = impares corpo

pares [] = []
pares (cab:corpo)
	| even cab = cab:(pares corpo)
	| otherwise = pares corpo

filtra [] f = []
filtra (cab:corpo) f
	| f cab = cab:(filtra corpo f)
	| otherwise = filtra corpo f

multiplos3 x = (mod x 3) == 0



--------
-- Exemplo de Java traduzido
pessoas = [("Fulano", "Silva", 40, 75.5), 
		   ("Ciclano", "Silva", 25, 120.0), 
		   ("Beltrano", "Silva", 70, 55.0)
			]
retornaNome (n,s,i,p) = n
saida = map retornaNome pessoas

saida2 = mapM_ (\(n,s,i,p) -> print n) pessoas

saida3 = putStr (unlines saida)



igual pal x = pal == x
ocorrencias [] palavra = 0
ocorrencias l palavra = length (filter (igual palavra) (words l))
--ocorrencias l palavra = length (filter (\x -> x == palavra) (words l))


-- !!!! Intervalo !!!!
-- Funções de Alta Ordem





