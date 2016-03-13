frases = ["A culpa é minha, eu coloco ela em quem eu quiser.",
 "Se alguma coisa está difícil de ser feita, é porque não é para ser feita",
 "É melhor ver coisas do que fazer coisas.",
 "A tentativa é o primeiro passo para o fracasso."]

quant_linhas texto = length texto

tamanho texto = foldl (\ x y -> x + (length y)) 0 texto

caracteres' [] = 0
caracteres' (cab:resto)
    | cab == ' ' = caracteres' resto
    | otherwise = 1 + caracteres' resto

caracteres texto = foldl (+) 0 (map caracteres' texto)

palavras [] delimits = [[]]
palavras (cab:resto) delimits
    | elem cab delimits = palavras resto delimits
    | otherwise = palavras' [cab] resto delimits

palavras' trecho [] delimits
    | null trecho = []
    | otherwise = [[trecho]]
palavras' trecho (cab:resto) delimits
    | elem cab delimits && not (null trecho) = [trecho]:(palavras' [] resto delimits)
    | elem cab delimits = palavras' [] resto delimits
    | otherwise = palavras' (trecho++[cab]) resto delimits

