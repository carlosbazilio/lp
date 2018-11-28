pantograma _ [] = True
pantograma frase (prim:resto)
    | not (elem prim frase) = False
    | otherwise = pantograma frase resto

pantograma' frase alfabeto
    | alfabeto == [] = True
    | frase == [] = False
    | otherwise = pantograma' (filter (/= (head frase)) frase) (filter (/= (head frase)) alfabeto)

