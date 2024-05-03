data Pilha a = 
    Vazia 
    | Pilha { topo :: a, 
              restante :: Pilha a } deriving Show

top :: Pilha a -> Maybe a
top Vazia = Nothing
top (Pilha t r) = Just t

push :: a -> Pilha a -> Pilha a
push el pilha = Pilha el pilha

push' :: [a] -> Pilha a
push' [] = Vazia
push' (cab:resto) = Pilha cab (push' resto)

pop :: Pilha a -> Pilha a
pop Vazia = Vazia
pop (Pilha t r) = r
