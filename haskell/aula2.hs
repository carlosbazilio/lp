-- soma [1,2,3]
-- 1 + soma [2,3]
-- ....
-- soma []

-- soma lista =
--     (head lista) + soma (tail lista)

-- soma :: [Int] -> Int
soma [] = 0
soma (cabeca:corpo) =
    cabeca + soma corpo

-- impares [] = []
-- impares (cabeca:corpo)
--     | odd cabeca = cabeca : impares corpo
--     | otherwise = impares corpo

-- pares [] = []
-- pares (cabeca:corpo)
--     | even cabeca = cabeca : pares corpo
--     | otherwise = pares corpo

filtra_valores [] checa_valor = []
filtra_valores (cabeca:corpo) checa_valor
    | checa_valor cabeca = cabeca : filtra_valores corpo checa_valor
    | otherwise = filtra_valores corpo checa_valor



