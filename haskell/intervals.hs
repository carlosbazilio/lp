type Interv = (Int, Bool, Int, Bool)
interval :: Int -> Bool -> Int -> Bool -> (Int, Bool, Int, Bool)
interval x bx y by
	| x > y = (0, False, 0, False)
	| otherwise = (x, bx, y, by)

intercepta :: [Interv] -> [Interv] -> [Interv]
intercepta _ [] = []
intercepta [] _ = []
-- intercepta 

