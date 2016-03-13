incr _ [] = []
incr x (a : b) = (x + a) : (incr x b)

incr3 :: Integer -> [Integer] -> [Integer]
incr3 _ [] = []
incr3 x (a : b) = (x + a) : (incr3 x b)

incr2 _ [] = []
incr2 x ((a1, a2) : b) = ((x + a1), a2) : (incr2 x b)

main = 5
