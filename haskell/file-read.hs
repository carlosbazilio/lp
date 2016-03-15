-- Author: Carlos Bazilio

-- Test file reading
-- Contents of file text.txt
-- 5
-- 7
-- [(1,2,3),(4,5,6),(7,8,9),(10,11,12)]

import Data.Char;

castString = read::String->[(Int, Int, Int)]

run :: IO (Int, Int, [(Int,Int,Int)])
run = do
	contents <- readFile "text.txt"   -- use '<-' here so that 'contents' is a String
	let [a,b,c] = lines contents      -- split on newlines
	let firstLine  = digitToInt $ head a
	let secondLine = digitToInt $ head b
	let thirdLine  = castString c    -- this reads a list of Int-tuples
	return (firstLine, secondLine, thirdLine)
