-- fatorial x = if (x == 0) then 1 else x * fat(x - 1)

-- fatorial x
--     | x == 0 = 1
--     | otherwise = x * fat (x - 1)

fatorial 0 = 1
fatorial n = fatorial(n-1) * n

fib 1 = 1
fib 2 = 1
fib n = fib (n - 1) + fib (n - 2)

