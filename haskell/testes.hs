import System.Random

fatorial :: Int -> Int
fatorial 0 = 1
fatorial n = fatorial (n-1) * n

dobro :: Int -> Int
dobro x = 2 * x

-- produto :: (Num a) => a -> a -> a
produto x y = x * y

dobro2 = produto 2

numeros = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]

car [] = []
car (cab:_) = cab
cdr (_:corpo) = corpo
cons elem lista = (elem:lista)

pertence _ [] = False
pertence el (cab:resto) | el == cab = True
						| otherwise = pertence el resto
			
-- tamanho :: [Int] -> Int
tamanho [] = 0
tamanho (cab:resto) | pertence cab resto = tamanho resto
					| otherwise = 1 + tamanho resto
						
uniao [] conj2 = conj2
uniao (cab1:resto1) conj2 | pertence cab1 conj2 = uniao resto1 conj2
						  | otherwise = uniao resto1 (cab1:conj2)
						  
type Matr = Integer
type Nome = String
type Cr = Double
type Aluno = (Matr, Nome, Cr)

joao = (1, "Joao", 10.0)
pessoa m n c = (m, n, c)

matr :: Aluno -> Matr
matr (m, _, _) = m
nome (_, n, _) = n
cr (_, _, c) = c

alunos = [joao, (1, "Joao", 8.5), (2, "Maria", 8.0), (3, "Jose", 7.5), (4, "Joana", 8.0)]

soma_cr :: [Aluno] -> Double
soma_cr [] = 0
soma_cr (prim : resto) = (cr prim) + (soma_cr resto)

cr_medio [] = 0
cr_medio x = (soma_cr x) / (fromIntegral (length x))

n_esimo _ [] = []
n_esimo n (prim : resto) | n == 1 = [prim]
                         | otherwise = n_esimo (n - 1) resto
                        
-- lista n m = [(x, y) | x <- [n .. m], y <- [n*2 .. m*2]]
lista n m = [(x, y) | x <- [n .. m], y <- [n .. dobro m], x < y]

-- map2 :: (Num t) => (t -> t) -> [t] -> [t]
map2 f [] = []
map2 f (cab:corpo) = (f cab):(map2 f corpo)

a = "Welington"
b :: [Char]
b = "Aline"

participantes = [("bazilio", "carlosbazilio@puro.uff.br"), ("moska", "emarques@puro.uff.br"),("dada", "dalessandrosoares@yahoo.com.br"), ("flavia","fcbernardini@gmail.com")]

codigos = [x | x <- [1 .. length participantes]]

num = randomRIO (1::Int, length participantes)

main = do
		gen <- newStdGen
		let ns = randoms gen :: [Int]
		print $ take 2 ns
		-- putStrLn "Greetings!  What is your name?"
		-- inpStr <- getLine
		-- putStrLn $ "Welcome to Haskell, " ++ inpStr ++ "!"


delta a b c = (b * b) - (4 * a * c)

raizes a b c = 
	if (delta a b c) >= 0 then
		(((-b) - (sqrt delta) / 2*a), ((-b) + (sqrt delta) / 2*a))

