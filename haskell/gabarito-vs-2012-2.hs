casa = [("sala", "porta", "jardim"), ("jardim", "porta", "sala"), ("sala", "escada", "telhado"), ("telhado", "escada", "sala")]

deslocar "porta" = "abrir porta para "
deslocar "escada" = "usar escada para "

-- partindo "sala" casa = ["jardim", "telhado"]
partindo x [] = []
partindo x ((y, w, z) : resto)
	| (x == y) = ((deslocar w) ++ z) : (partindo x resto)
	| otherwise = (partindo x resto)
	
comodos [] = 0
comodos l = length (comodos_aux l [])
comodos_aux [] lugares = lugares
comodos_aux ((y, _, z) : resto) lugares
	| (notElem y lugares) && (notElem z lugares) = comodos_aux resto (y : (z : lugares))
	| (notElem y lugares) = comodos_aux resto (y : lugares)
	| (notElem z lugares) = comodos_aux resto (z : lugares)
	| otherwise = comodos_aux resto lugares
	

