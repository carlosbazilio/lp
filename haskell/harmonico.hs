harmonico x y = 
	if (x > y) then 0 
	else (1 / x) + (harmonico (x + 1) y)

harmonico_gen x y f = 
	if (x > y) then 0 
	else (f x) + (harmonico_gen (x + 1) y f)



