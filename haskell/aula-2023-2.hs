
-- maximo a b = if (a > b) then a else b

maximo a b
    | a > b = a
    | otherwise = b

-- fatorial n =
--     if n == 0 then 1
--     else n * fatorial (n - 1)

-- fatorial n
--     | n == 0 = 1
--     | otherwise = n * fatorial (n - 1)

fatorial 0 = 1  -- Casamento de padrões (pattern matching)
fatorial n = n * fatorial (n - 1)

-- 0 1 1 2 3 5 8 13 21 ...

fib 1 = 0
fib 2 = 1
fib n = fib (n - 1) + fib (n - 2)

-- harmonico inf sup
--     | inf > sup = 0
--     | otherwise = (1 / (inf * inf)) + harmonico (inf + 1) sup

-- inversa i = 1 / i

inversa = \i -> 1 / i  -- Definição usando função anônima

harmonico inf sup func
    | inf > sup = 0
    | otherwise = (func inf) + harmonico (inf + 1) sup func


-- /////////////////// --
-- LISTAS --
-- /////////////////// --

temperatura :: [Double]
temperatura = [-30, -5, 10, 15, 0, -25, 18, -40]

soma [] = 0
-- soma lista = head lista + soma (tail lista)  -- head / tail
soma (prim : restante) = prim + soma restante

tamanho [] = 0
-- tamanho lista = 1 + tamanho (tail lista)
tamanho (_ : restante) = 1 + tamanho restante

media lista = (soma lista) / (tamanho lista)

----

c2f t = t * (9/5) + 32
c2k t = t + 273.15

-- celsius2farenheint [] = []
-- celsius2farenheint (prim : restante) = (c2f prim) : (celsius2farenheint restante)

-- celsius2kelvin [] = []
-- celsius2kelvin (prim : restante) = (c2k prim) : (celsius2kelvin restante)

celsius2temp [] _ = []
celsius2temp (prim : restante) ftemp = (ftemp prim) : (celsius2temp restante ftemp)


--- Como fundir as 2 versões de conversão de temperatura numa única função ???

--- Como seria uma função para filtrar temperaturas de forma só ter, por exemplos, temperaturas negativas ???
