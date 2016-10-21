module Main where
	data Posicao t = Posicao t deriving (Show)

	salto (Posicao d) = Posicao (d + 2)
	passo (Posicao d) = Posicao (d + 1)

	rtn x = x
	x >>== f = f x
	x $$ f = f x

	treasureMap pos = pos $$ 
					  salto $$
					  salto $$
					  passo $$
					  rtn
