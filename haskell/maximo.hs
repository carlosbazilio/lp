maximo :: Int -> Int -> Int
maximo a b =
	if a > b then a else b

minimo a b
	| a < b = a | otherwise = b

harmonico :: Int -> Int -> (Int -> Int) -> Int
harmonico inicio fim f
	| inicio > fim = 0
	| otherwise = (f inicio) + 
		(harmonico (inicio + 1) fim f)

razao i = 1 / i

divisao_segura x y = x / (if y == 0 then 0.1 else y)

-- :t razao no prompt

impares [] = []
impares (cabeca:corpo)
	-- | (odd cabeca) = [cabeca] ++ (impares corpo)
	| (odd cabeca) = cabeca : (impares corpo)
	| otherwise = impares corpo

pares [] = []
pares (cabeca:corpo)
	| (even cabeca) = cabeca : (pares corpo)
	| otherwise = pares corpo

filtra [] p = []
filtra (cabeca:corpo) p
	| (p cabeca) = cabeca : (filtra corpo p)
	| otherwise = filtra corpo p 










