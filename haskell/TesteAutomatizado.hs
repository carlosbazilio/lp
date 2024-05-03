module TesteAutomatizado
( testaFuncao
) where

testaFuncao f casos = 
    foldl (\ac (entrada, saida) -> ac && (testeCaso f entrada saida)) 
    True
    casos 

testeCaso f entrada saida = 
    (f entrada) == saida 
