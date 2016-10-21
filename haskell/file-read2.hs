-- Author: Carlos Bazilio

-- Test file reading
-- Contents of file text.txt
-- [(1,2,3),(4,5,6),(7,8,9),(10,11,12)]

-- call: run (read::String->[(Int, Int, Int)])

import Data.Char;

castString = read::String->[(Int, Int, Int)]

run :: (String -> a) -> IO [a]
run f = do
	contents <- readFile "text2.txt"   -- use '<-' here so that 'contents' is a String
	let x = lines contents      -- split on newlines
	return (map f x)

