count x l
	| (l == []) = 0 
	| ((head l) == x) = 1 + (count x (tail l)) 
	| otherwise = count x (tail l)

main = print (foldl (+) 0 (map (count 'a') ["abcd", "abcddef"]))

