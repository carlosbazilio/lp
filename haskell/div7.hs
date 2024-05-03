div7 n
    | n < 7 = False
    | n == 7 = True
    | otherwise = div7 (((mod n 10) * 5) + (div n 10))
