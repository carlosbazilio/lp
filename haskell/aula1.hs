maximo a b = if a > b then a else b

fracao x = 1 / x

harmonico lim_inf lim_sup f = 
    if (lim_inf == lim_sup) then 
        --1 / lim_inf
        f lim_inf
    else 
        (f lim_inf) + (harmonico (lim_inf + 1) lim_sup f)

fat 0 = 1
fat x = x * (fat (x - 1))

comb n p = (fat n) / (fat p) * (fat (n - p))







