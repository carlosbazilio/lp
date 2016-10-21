somatorio li ls f
	| li > ls = 0
	| otherwise = (f li) + (somatorio (li + 1) ls f)

