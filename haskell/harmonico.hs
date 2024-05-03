harmonico x y
    | (x > y) = 0 
    | otherwise =  (1 / x) + (harmonico (x + 1) y)

harmonico_gen x y f
    | (x > y) = 0
    | otherwise = (f x) + (harmonico_gen (x + 1) y f)

inversa x = 1 / x


