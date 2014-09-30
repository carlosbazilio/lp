merge :: [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys) = | x < y = x:y:merge xs ys
                      | x > y = y:x:merge xs ys
                      | x==[] = y:merge xs ys
                      | y==[] = x:merge xs ys
                      | otherwise = []