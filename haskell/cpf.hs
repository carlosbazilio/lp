-- cpf = [1, 0, 3, 1, 2, 4, 9, 2, 1]
cpf = [0, 0, 5, 7, 7, 6, 0, 1, 6]

normaliza x
    | (mod x 11) == 10 = 0
    | otherwise = mod x 11

somaprod l1 l2 = foldl (+) 0 (zipWith (*) l1 l2)

calculaDigito l = [normaliza (somaprod l [1..9]), 
                   normaliza (somaprod l [9,8..1])]

verificaDigito l d1 d2 = let [d1', d2'] = (calculaDigito l) in ((d1 == d1') && (d2 == d2'))

