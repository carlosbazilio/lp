peakfinder [] = -1
peakfinder (x:[]) = x
peakfinder (x:y:[]) = max x y
peakfinder (x:y:z:resto)
    | y > x && y > z = y
    | otherwise = peakfinder (y:z:resto)
