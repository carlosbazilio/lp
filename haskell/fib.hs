fib 1 = 0
fib 2 = 1
fib n = fib_aux n 1 1

fib_aux n ant cor
    | n == 3 = cor
    | otherwise = fib_aux (n-1) cor (ant+cor)

fib_primeiros n
    | n == 1 = [0]
    | otherwise = fib_primeiros (n-1) ++ [fib n]

fib0 1 = 0
fib0 2 = 1
fib0 n = (fib0 (n-1)) + (fib0 (n-2))

memoi x [] = Nothing
memoi x ((x' , v):ys)
    | x == x' = v
    | otherwise = memoi x ys

add_memoi x v values = (x,v):values

eval_fib_memoi 1 _ = 0
eval_fib_memoi 2 _ = 1
eval_fib_memoi n values
    | memoi n values == Nothing = (eval_fib_memoi n values) + (eval_fib_memoi n values)
    

