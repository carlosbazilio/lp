data ArvBin a = 
    Vazia 
    | ArvBin { raiz :: a, 
               esq :: ArvBin a, 
               dir :: ArvBin a } deriving Show

insereValor n = ArvBin n Vazia Vazia

insereArvOrd n Vazia = insereValor n
insereArvOrd n (ArvBin r e d)
    | (n == r) = ArvBin r e d
    | (n > r) = ArvBin r e (insereArvOrd n d)
    | otherwise = ArvBin r (insereArvOrd n e) d

pertence n Vazia = False
pertence n (ArvBin r e d) = (n == r) || pertence n e || pertence n d

pertenceOrd n Vazia = False
pertenceOrd n (ArvBin r e d)
    | (n == r) = True
    | (n > r) = pertence n d
    | otherwise = pertence n e

