contain c [] = False
contain c (cab:corpo)
    | c == cab = True
    | otherwise = contain c corpo

