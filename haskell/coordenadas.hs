pontos = [(0,0,0),(-10,10,10),(10,20,30),(20,-20,40)]

reduz2D lista = 
    map (\(x,y,_) -> (x,y)) lista

filtra1quadrante lista = 
    filter (\(x,y,z) -> x >= 0 && y >= 0 && z >= 0) lista

somaCoordenadas lista = 
    foldl (\ac (x,y,z)-> ac + x + y + z) 0 lista

