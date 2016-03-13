rempairl [] cab = [cab]
rempairl lista cab
    | (last lista) == cab = lista
    | otherwise = lista ++ [cab]

remdupsl lista = foldl rempairl [] lista

rempairr cab [] = [cab]
rempairr cab lista
    | (head lista) == cab = lista
    | otherwise = cab : lista

remdupsr lista = foldr rempairr [] lista
