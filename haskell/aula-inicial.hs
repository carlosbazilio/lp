-- dobro :: Int -> Int
dobro :: Num a => a -> a
dobro k = 2 * k

-- (Num a, Int b) => a, b -> a

-- (Num p), (Num p) -> p
-- Num p => p, p -> p

-- potencia :: Num p => p, p -> p
potencia :: Floating a => a -> a -> a
potencia x y = x ** y

-- maximo a b = 
--     if a > b then a else b 

maximo :: Ord a => a -> a -> a
maximo a b 
    | a > b = a
    | otherwise = b 

-- fatorial x
--     | x == 0 = 1
--     | otherwise = x * fatorial (x-1)

fatorial :: (Eq p, Num p) => p -> p
fatorial 0 = 1
fatorial x = x * fatorial (x-1)

-- harmonico :: Num a => a->a->(a->a)->a
harmonico :: (Eq t, Num a, Num t) => t -> t -> (t -> a) -> a
harmonico i j f
    | i == j = f j
    | otherwise = (f i) + (harmonico (i+1) j f)


fib 0 = 0
fib 1 = 1
-- fib n = (fib (n-1)) + (fib (n-2))
fib n = fib_aux n 0 1

fib_aux 0 ant _ = ant
fib_aux n ant corr = fib_aux (n-1) corr (corr + ant)

-- termos_fib :: Int -> [Int]
-- termos_fib :: (Eq num, Num num, Num num2) => num -> [num2]
termos_fib :: (Eq t, Num t, Num a) => t -> [a]
termos_fib 0 = []
-- termos_fib n = (fib n) : (termos_fib (n-1))
termos_fib n = termos_fib (n-1) ++ [(fib n)]


soma [] = 0
-- soma x = (head x) + (soma (tail x))
soma (cab:corpo) = cab + (soma corpo)
-- soma (cab:cab2:corpo) = cab + cab2 + (soma corpo)

soma_termos_fib 0 = 0
-- soma_termos_fib n = soma (termos_fib n)
soma_termos_fib n = harmonico 0 n fib

-- tamanho :: [any] -> Int
tamanho [] = 0
tamanho (cab:corpo) = 1 + tamanho corpo

-- mapeia :: [Int] -> (Int -> Int) -> [Int]
-- mapeia :: Num a => [a] -> (a->a) -> [a]
mapeia :: [t] -> (t -> a) -> [a]
mapeia [] _ = []
mapeia (cab:corpo) f = (f cab) : (mapeia corpo f)
-- mapeia (cab:corpo) f = (mapeia corpo f) ++ [f cab]

impares [] = []
impares (cab:corpo)
    | (mod cab 2) /= 0 = cab : (impares corpo)
    | otherwise = impares corpo

quicksort [] = []
quicksort (cab:resto) =
    (quicksort [x | x <- resto, x < cab]) ++
    [cab] ++
    (quicksort [x | x <- resto, x > cab])

imparesOrdenados lista = quicksort (impares lista)

f :: (Eq a, Num a) => a -> a
f 0 = 0
f 1 = 1
f n = f (n-1) + f (n-2)

fib2 :: (Eq a, Num a) => a -> [a]
fib2 n
    | n == 0 = [f 0]
    | otherwise = fib2 (n-1) ++ [f n]

intersecao :: Eq a => [a] -> [a] -> [a]
intersecao [] _ = []
intersecao (x:xs) ys
    -- | x `elem` ys = x : intersecao xs ys
    | elem x ys = x : intersecao xs ys
    | otherwise = intersecao xs ys

repete :: Int -> [Int]
repete 0 = []
-- repete 1 = [1]
-- repete 2 = [2,2]
repete valor = take valor (repeat valor) ++ repete (valor-1)

-- > rodar-esquerda 1 “asdfg”
-- “sdfga”
-- > rodar-esquerda 3 “asdfg”
-- “fgasd”

rodaesq :: Int -> [banana] -> [banana]
-- rodaesq a [l] = drop a [l] ++ list
--     where
--         list = take a [l]
rodaesq x string = (drop x string) ++ (take x string)

-- > remDuplicatas [1, 2, 4, 2, 6, 5, 3, 4]
-- [1, 2, 4, 6, 5, 3]

existe x [] = False
existe x (cab1:corpo) 
    | x == cab1 = True
    | otherwise = (existe x corpo)
    
remDuplicatas [] = []
remDuplicatas (corpo : []) = [corpo]
remDuplicatas (cab1:corpo)
        | (existe cab1 corpo) = remDuplicatas corpo
        | otherwise = cab1 : (remDuplicatas corpo)

-- > somaQuadrados 2
-- 5     // 12 + 22
-- > somaQuadrados 4
-- 30     // 12 + 22 + 32 + 42

-- quadradoLista :: Int -> [Int]
quadradoLista 0 = []
quadradoLista y = [x^2 | x <- [1..y]]

somaLista :: [Int] -> Int
somaLista [] = 0
somaLista (x:xs) = x + somaLista xs

somaQuadrados n = somaLista (quadradoLista n)

inverte :: [l] -> [l]
inverte [] = []
inverte (aux:x) = (inverte x) ++ [aux]

type Codigo = Int
type Nome = [Char]
type Sobrenome = [Char]
type Nota = Float
-- type Aluno2 = (Codigo, Nome, Sobrenome, Nota)

raphael2 = (2, "raphael", "kazuhiro", 10)
gabriel2 = (1, "gabriel", "ribeiro", 10)
alunos2 :: [(Codigo, Nome, Sobrenome, Nota)]
alunos2 = [gabriel2, raphael2]

nota2 (_, _, _, n) = n

media l = (foldl (\ x y -> x + y) 0 l) / (fromIntegral $ length l)

data Pessoa = Aluno { codigo::Codigo, 
                      nome::Nome, 
                      sobrenome::Sobrenome, 
                      nota::Nota }
            | Professor { codigo::Codigo, 
                          nome::Nome, 
                          sobrenome::Sobrenome }
    deriving (Show, Eq)

raphael = Aluno 2 "Raphael" "Kazuhiro" 10
gabriel = Aluno 1 "Gabriel" "Ribeiro" 10
bazilio = Professor 3 "Carlos" "Bazilio"

pessoas = [raphael, gabriel, bazilio]

-- Kazuhiro, R.

citacao :: Pessoa -> String
-- citacao (Aluno _ nome sobrenome _) = converte_citacao nome sobrenome
-- citacao (Professor _ nome sobrenome) = converte_citacao nome sobrenome
citacao p = converte_citacao (nome p) (sobrenome p)
converte_citacao nome sobrenome = sobrenome ++ ", " ++ nome ++ "."

pertence :: [Pessoa] -> String -> Bool
pertence pessoas nomeBuscado
    | length (filter (\p -> substr nomeBuscado (nome p)) pessoas) > 0 = True
    | otherwise = False

substr [] [] = True
substr _ [] = False
substr (cab:resto) (cab2:resto2)
    | (cab == cab2) && (inicia resto resto2) = True
    | otherwise = substr (cab:resto) resto2

inicia [] [] = True
inicia _ [] = False
inicia [] _ = True
inicia (cab:resto) (cab2:resto2)
    | (cab == cab2) = inicia resto resto2
    | otherwise = False


