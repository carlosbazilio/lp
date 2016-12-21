pot _ 0 = 1
pot x y = x * (pot x (y-1))

pot2 x y
	| (y == 0) = 1
	| otherwise = x * (pot2 x (y-1))

pot3 x y = if y == 0 then 1 else x * (pot3 x (y-1))



