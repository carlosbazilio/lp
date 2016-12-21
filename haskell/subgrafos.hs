nos = [1,2,3,4,5,6]
arestas = [(1,2),(1,3),(4,5),(4,6)]
subgrafos grafo = [(x,y) | (x,y) <- grafo, (p,q) <- grafo, (((x == p) && (y /= q)) || ((x /= p) && (y == q)))]
arestas_no grafo x = [(p,q) | (p,q) <- grafo, ((x == p) || (x == q))]
intersecao a b = [x | y <- a, z <- b, ((x == y) && (x == z))]

sub sublistas [] = sublistas
sub (prim:sublistas) [(x,y):resto]
	| member x prim = (y:prim):sublistas
	| member y prim = (x:prim):sublistas
	| otherwise = prim:(sub sublistas [(x,y):resto])

--conexoes grafo x = [n | (((x,n) <- grafo) || ((n,x) <- grafo))]
conexoes grafo x = [q | (p,q) <- grafo, x == p] ++ [q | (q,p) <- grafo, x == p]

--map (conexoes arestas) nos
