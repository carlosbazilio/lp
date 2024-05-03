-- fat x = 
--     if x == 0 then 
--         1 
--     else 
--         x * (fat (x - 1))

fat :: Integral p => p -> p
fat 0 = 1 -- Pattern matching
fat x = x * (fat (x - 1))

-- fib x =
--     if x <= 1 then
--         x
--     else
--         fib (x-1) + fib (x-2)

-- fib 0 = 0
-- fib 1 = 1
-- fib x = fib (x-1) + fib (x-2)

-- fib x
--     | x == 0 = 0
--     | x == 1 = 1
--     | otherwise = fib (x-1) + fib (x-2)

fib x = fib_aux x 0 1
fib_aux x corr prox
    | x == 0 = corr
    | otherwise = fib_aux (x-1) prox (corr+prox)

-- harmonico a b 
--     | a == b = 1 / a
--     | otherwise = (1 / a) + (harmonico (a+1) b)

inversa i = 1 / i

inversa2 i = 1 / (i * i)

harmonico a b f
    | a == b = f a
    | otherwise = (f a) + (harmonico (a+1) b f)

valores_sensor = [50, 49.5, 51.2, -10.3, 45.2, -20.4]

-- soma_temperaturas [] = 0
-- soma_temperaturas lista 
--     | (head lista) > 0 = (head lista) + (soma_temperaturas (tail lista))
--     | otherwise = (soma_temperaturas (tail lista))

-- soma_temperaturas_neg [] = 0
-- soma_temperaturas_neg lista 
--     | (head lista) < 0 = (head lista) + (soma_temperaturas_neg (tail lista))
--     | otherwise = (soma_temperaturas_neg (tail lista))

-- soma_temperaturas [] _ = 0
-- soma_temperaturas lista op
--     | op (head lista) = (head lista) + (soma_temperaturas (tail lista) op)
--     | otherwise = (soma_temperaturas (tail lista) op)

soma_temperaturas [] _ = 0
soma_temperaturas (cabeca:corpo) op
    | op cabeca = cabeca + (soma_temperaturas corpo op)
    | otherwise = (soma_temperaturas corpo op)

filtra_positivas [] = []
filtra_positivas (cabeca:corpo)
    | cabeca > 0 = cabeca:(filtra_positivas corpo)
    | otherwise = filtra_positivas corpo

-- *Main> filtra [1..10] (\x -> x >= 3 && x < 8)
-- [3 4 5 6 7]
filtra :: [a] -> (a -> Bool) -> [a]
filtra [] _ = []
filtra (cabeca:corpo) op
    | op cabeca = cabeca:(filtra corpo op)
    | otherwise = filtra corpo op

-- Versão da Thayná
-- dobro :: Float -> Int 
-- dobro x = round (2 * x)

dobro :: Num a => a -> a
dobro x = 2 * x

-- soma :: Num a b => a b -> a || b
-- soma :: Num a => a -> a -> a
soma x y = x + y 

type Matr = Int
type Nome = [Char]
type Cidade = [Char]
type Nota = Float
-- type Aluno = (Matr  Nome  Cidade  Nota)

data Pessoa = Aluno { mat :: Matr,
                      nome :: Nome,
                      cidade :: Cidade,
                      nota :: Nota } deriving (Show)

alunos :: [Pessoa]
-- alunos = [(1 "gabriel" "rio das ostras" 9) (2 "raphael" "volta redonda" 10) (3 "kassiano" "unamar" 10) (4 "igor" "macae" 8)]

alunos = [Aluno 1 "gabriel" "rio das ostras" 9, Aluno 2 "raphael" "volta redonda" 10, Aluno 3 "kassiano" "unamar" 10, Aluno 4 "igor" "macae" 8]

-- matr :: Aluno -> Matr
-- matr (m n c nt) = m
-- nome (m n c nt) = n
-- cidade (m n c nt) = c
-- nota (m n c nt) = nt

-- matr :: Pessoa -> Matr
-- matr (Aluno m n c nt) = m







