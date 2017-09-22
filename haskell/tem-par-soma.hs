tempar [] _ = False
tempar lista n = tempar_aux lista n []
tempar_aux [] _ _ = False
tempar_aux (cab:resto) n complementos
	| elem (n-cab) complementos = True
	| otherwise = tempar_aux resto n ((n-cab):complementos)
