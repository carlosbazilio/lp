merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
	| x < y = x:merge xs (y:ys)
    | otherwise = y:merge (x:xs) ys
