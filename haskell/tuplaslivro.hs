type Livro = (Integer, [Char], [Char], Double, Double)

livros :: [Livro]
livros = [(1,"Eu sou Malala","Malala Yousafzai",50.0,2.0),
          (2,"Engenharia de Software","Ian Sommerville",200.0,4.0),
          (3,"O Principe","Maquiavel",150.0,1.0),
          (4,"The Atrocity Archives","Charles Stross",300.0,2.0)]

getPreco :: Livro -> Double
getPreco (id, titulo, autor, preco, qtd) = preco

getQtd :: Livro -> Double
getQtd (id, titulo, autor, preco, qtd) = qtd

getValorEstoque :: Livro -> Double
getValorEstoque (id, titulo, autor, preco, qtd) = preco * qtd

somalivros :: [Livro] -> Double
somalivros lista = foldl (\x y -> x + getValorEstoque y) 0 lista

-- main = 
--     print (foldl (\x (id1, titulo1, autor1, preco1, qtd1) -> (preco1 * qtd1) + x) 0 livros)

