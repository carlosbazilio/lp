isPermutation :: Eq a => [a] -> [a] -> Bool

isPermutation [] [] = True
isPermutation [] _ = False
isPermutation _ [] = False


