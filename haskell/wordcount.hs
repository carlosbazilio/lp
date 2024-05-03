-- wordcount ["Um delicioso cafe", "Um cafe acorda!", "Bora tomar um cafe"] => [("um", 3), ("cafe", 3), ("delicioso", 1), ("acorda", 1), ("Bora", 1), ("tomar", 1)]

--wordcount textos = map (\t -> tuplas t) textos

--tuplas [] resultado = resultado
--tuplas (cab)

wordcount [] [] = []
--wordcount2 palavras ()

split :: String -> Char -> [String]
split [] delim = [""]
split (c:cs) delim
    | c == delim = "" : rest
    | otherwise = (c : head rest) : tail rest
    where
        rest = split cs delim

split' :: String -> String -> [String] -> [String]
split' [] _ acum = acum
split' (prim:resto) delim acum
    | elem prim delim = split' resto delim (insereFechaTermo acum)
    | otherwise = split' resto delim (insereCaracterNoFim prim acum)

insereFechaTermo acum = acum ++ [""]

insereCaracterNoFim caracter acum = (init acum) ++ [(last acum) ++ [caracter]]