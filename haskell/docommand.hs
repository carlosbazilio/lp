module Main where

foo :: Maybe String  
foo = do  
    x <- Just 3
    y <- Just "!"
    Just (show x ++ y)

unfoo :: Maybe String -> String
unfoo Nothing = "String não gerada"
unfoo (Just x) = x

main = do 
   { putStr "Hello"
   ; putStr " "
   ; putStr "world!"
   ; putStr "\n"
   ; putStr $ unfoo foo
   ; putStr "\n" }

