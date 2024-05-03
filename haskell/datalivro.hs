data Pub = Livro { cod :: Integer, 
                   titulo :: [Char], 
                   autor :: [Char],
                   preco :: Double,
                   qtd :: Double
                 } deriving (Show)    

-- data Pub = Livro Integer [Char] [Char] Double Double deriving (Show)

livros :: [Pub]
livros = [Livro 1 "Eu sou Malala" "Malala Yousafzai" 50.0 2.0, 
          Livro 2 "Engenharia de Software" "Ian Sommerville" 200.0 4.0, 
          Livro 3 "O Principe" "Maquiavel" 150.0 1.0, 
          Livro 4 "The Atrocity Archives" "Charles Stross" 300.0 2.0]

-- getPreco :: Pub -> Double
-- getPreco (Livro id titulo autor preco qtd) = preco

-- getQtd :: Pub -> Double
-- getQtd (Livro id titulo autor preco qtd) = qtd

-- getValorEstoque :: Pub -> Double
-- getValorEstoque (Livro id titulo autor preco qtd) = preco * qtd

-- somalivros :: [Pub] -> Double
-- somalivros lista = foldl (\x y -> x + getValorEstoque y) 0 lista

