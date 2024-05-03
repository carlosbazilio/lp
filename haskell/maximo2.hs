-- maximo a b = if a > b then a else b

maximo a b
    | a > b = a
    | otherwise = b

-- fatorial x
--     | x == 0 = 1
--     | otherwise = x * fatorial (x - 1)

fatorial 0 = 1
fatorial x = x * fatorial (x - 1)

-- Definicao
-- nome_funcao parametros = expressao
-- Chamada
-- nome_funcao argumentos

-- H100 = SUM (i=1,100) 1/i
-- Hn = SUM (i=1,n) 1/i

-- harmonico i i = 1 / i
-- harmonico i j = (1 / j) + harmonico i (j - 1)

-- fracao x y = x / y

inversa x = 1 / x

quadrado z = z * z

harmonico i j func
    | (i == j) = func i -- 1 / i
    | otherwise = (func j) + harmonico i (j - 1) func

soma [] = 0
-- soma lista = head lista + soma (tail lista)
soma (primeiro : restante) = primeiro + soma restante

-- pares [1,2,3,4,5,6,7,8]
-- [2,4,6,8]

par x = (mod x 2) == 0

-- pares [] = []
-- pares (primeiro : restante)
--     | par primeiro = primeiro : (pares restante)
--     | otherwise = pares restante

-- -- pares lista = [x | x <- lista, par x]

-- impares [] = []
-- impares (primeiro : restante)
--     | not (par primeiro) = primeiro : (impares restante)
--     | otherwise = impares restante

filtra [] fteste = []
filtra (primeiro : restante) fteste
    | fteste primeiro = primeiro : (filtra restante fteste)
    | otherwise = filtra restante fteste














