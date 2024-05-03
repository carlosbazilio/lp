-- primo :: Int -> Bool
primo x = primo_aux x 2
-- primo_aux :: Int -> Int -> Bool
primo_aux 2 _ = True
primo_aux x y
  | y > (div x 2) = True
  | (mod x y) == 0 = False
  | otherwise = primo_aux x (y+1)

