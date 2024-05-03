fat 0 = 1
fat n = n * fat(n-1) 

pot x n
    | x == n = True
    | mod x n /= 0 = False
    | otherwise = pot (div x n) n
