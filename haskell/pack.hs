-- Exemplo de uso
-- > pack "abcdaabbcc"
-- ["a","b","c","d","aa","bb","cc"]

pack :: [Char] -> [[Char]]
pack [] = [[]]
pack (a : resto) = pack1 resto [a] []

-- 1o parametro: analisa a string de entrada
-- 2o parametro: current guarda a substring que está sendo acumulada (lista)
-- 3o parametro: result guarda o resultado acumulado a ser retornado (lista de lista)
pack1 [] current result = (result ++ [current])
pack1 (a : resto) current result
    | (a == (head current)) = pack1 resto (a : current) result
    | otherwise = pack1 resto [a] (result ++ [current])
