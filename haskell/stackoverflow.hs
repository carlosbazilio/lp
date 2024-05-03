locate [] _ = -1
locate phrase pair = locate_aux phrase pair (locateZip phrase)
locate_aux _ _ [] = -1
locate_aux (x:xs) (y1:y2:ys) h = 
    if (fst (fst (head h)) == y1) && (snd (fst (head h)) == y2) then 
        snd (head h) 
    else
        locate_aux xs (y1:y2:ys) (tail h)
    -- where h = head(locateZip (x:xs))
locateZip xs = zip(zip xs(tail xs)) [0..]

-- Finds the index of a char in a string
-- findPos :: (Num a1, Enum a1, Eq a2) => [a2] -> a2 -> [a1]
-- findPos str c = [index | (x, index) <- zip str [0..], x == c]

-- -- findPosStr "foobarfoobar" "oo"
-- findPosStr word term = map (\c -> findPos word c) term
