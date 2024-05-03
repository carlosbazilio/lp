caracteres = [('(',')'), ('[',']'), ('{','}')]
abres itens = [x | (x,y) <- itens]
fechas itens = [y | (x,y) <- itens]

par c [] = ' '
par c ((a,f):resto)
    | c == a = f
    | c == f = a
    | otherwise = par c resto

testap expr = testap' expr [] (abres caracteres) (fechas caracteres)
testap' [] [] _ _ = True
testap' [] (topo:base) _ _ = False
testap' (cab:resto) pilha abres fechas
    | elem cab abres = testap' resto (cab:pilha) abres fechas
    | elem cab fechas && pilha == [] = False
    | elem cab fechas && (head pilha) == (par cab caracteres) = testap' resto (tail pilha) abres fechas
    | elem cab fechas && (head pilha) /= (par cab caracteres) = False
    | otherwise = testap' resto pilha abres fechas
