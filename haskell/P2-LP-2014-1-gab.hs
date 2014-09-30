
--1)
mistura [] [] = []
mistura [] lista = lista
mistura lista [] = lista
mistura (cab:resto) (cab2:resto2) = cab : cab2 : (mistura resto resto2)

--2)
mult2 (x, y) =  x * y

mult3 [] = 0
mult3 (cab : resto) = (mult2 cab) + (mult3 resto)

reduz f acum [] = acum
reduz f acum (cab : resto) = reduz f (f cab acum) resto

mult31 lista = reduz (+) 0 (map mult2 lista)

--main = print (mistura [1, 2, 3, 4] [5])
--main = print (mult3 [(4,6), (3,7), (5,4), (5,5)])
-- main = print (mult31 [(4,6), (3,7), (5,4), (5,5)])

main = print (map mult2 [(4,6), (3,7), (5,4), (5,5)])

