rotations [] = []
rotations [x] = [[x]]
rotations lista = rotations' lista (length lista)

rotations' (cab:corpo) qtd
    | qtd > 0 = (cab:corpo):(rotations' (corpo ++ [cab]) (qtd - 1))
    | otherwise = []
