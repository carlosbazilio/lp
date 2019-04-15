ftermo (coef, expo) x = (x ** expo) * coef

fpolinomial [] x = 0
fpolinomial ((coef, expo):resto) x = ((x ** expo) * coef) + (fpolinomial resto x)

fpolinomial' pol x = foldl (\acum (coef,expo) -> ftermo (coef,expo) x) 0 pol

soma [] x = x
soma x [] = x
soma p1 p2 = simplifica (p1 ++ p2) []

simplifica [] p = p
simplifica ((coef, expo):resto) p 
    | nao_possui_expoente p expo = simplifica 
                                   resto 
                                   [(soma_coef (filter (\(c, e) -> e == expo) ((coef, expo):resto)), expo)] ++ p
    | otherwise = simplifica resto p

soma_coef p = foldl (\x (y,z)->x+y) 0 p

nao_possui_expoente p expo = (filter (\(c,e)->e==expo) p) == []
