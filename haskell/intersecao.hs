-- intersecao [3,6,5,7] [9,7,5,1,3]
-- [3,5,7]

intersecao [] _ = []
intersecao _ [] = []
intersecao (cab:corpo) lista2
    | elem cab lista2 = cab : (intersecao corpo lista2)
    | otherwise = intersecao corpo lista2
