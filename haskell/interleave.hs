interleave [] [] = []
interleave x [] = x
interleave [] x = x
interleave (cab1:resto1) (cab2:resto2) = cab1:cab2:(interleave resto1 resto2)

expand_inv [] = []
expand_inv lista = expand_inv' lista (length lista)
expand_inv' [] _ = [] 
expand_inv' (cab:resto) qtd = (expand_inv' resto (qtd - 1)) ++ (replicate qtd cab)

frequencies [] = []
frequencies (cab:resto) = (cab, (length [x | x<-resto, x==cab]) + 1) : 
                          (frequencies (filter (\x -> x /= cab) resto))
