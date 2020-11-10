balanced [] = True
balanced cadeia = balanced' cadeia 0 0 0

balanced' [] 0 0 0 = True
balanced' [] _ _ _ = False
balanced' (cab:resto) paren colch chav
    | cab == '(' = balanced' resto (paren+1) colch chav
    | cab == ')' && (paren == 0) = False
    | cab == ')' = balanced' resto (paren-1) colch chav
    | cab == '[' = balanced' resto paren (colch+1) chav
    | cab == ']' && (colch == 0) = False
    | cab == ']' = balanced' resto paren (colch-1) chav
    | cab == '{' = balanced' resto paren colch (chav+1)
    | cab == '}' && (chav == 0) = False
    | cab == '}' = balanced' resto paren colch (chav-1)
    | otherwise = balanced' resto paren colch chav
