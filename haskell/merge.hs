merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
    | x < y = x:merge xs (y:ys)
    | otherwise = y:merge (x:xs) ys

merge' xs [] = xs
merge' [] ys = ys
merge' l1@(x:xs) l2@(y:ys)
    | x < y = x:merge' xs l2
    | otherwise = y:merge' l1 ys
