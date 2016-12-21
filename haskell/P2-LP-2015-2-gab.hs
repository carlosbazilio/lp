-- 2.a)
tamanho [] = 0
tamanho (cab:resto) = 1 + tamanho resto

tamanhos [] = []
tamanhos (cab:resto) = (tamanho cab) : (tamanhos resto)

tamanhos' lista = map length lista

-- 2.b)
soma [] = 0
soma (cab:resto) = cab + soma resto

soma' lista = foldl (+) 0 lista
