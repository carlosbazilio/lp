-- 3.a)
pertence el [] = False 
pertence el (cab:resto) 
	| el == cab = True
	| otherwise = pertence el resto

tamanho [] = 0
tamanho (cab:resto)
	| pertence cab resto = tamanho resto
	| otherwise = 1 + (tamanho resto)

-- 3.b)
uniao [] [] = []
uniao c1 [] = c1
uniao [] c2 = c2
uniao (cab1:resto1) c2
	| pertence cab1 c2 = uniao resto1 c2
	| otherwise = (cab1):(uniao resto1 c2)
