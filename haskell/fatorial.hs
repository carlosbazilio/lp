fatorial 0 = 1
fatorial n = fatorial(n-1) * n

fib 1 = 1
fib 2 = 1
fib n = fib (n - 1) + fib (n - 2)

h x
    | x > 0 = (1/x) + h(x-1)
    | otherwise = 0

fracao x = 1 / x

h' x f
    | x > 0 = (f x) + h' (x-1) f
    | otherwise = 0

