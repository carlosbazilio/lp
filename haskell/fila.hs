deque [] = []
deque (prim:_) = [prim]
enqueue [] c = [c]
enqueue (prim:restante) c = prim:(enqueue restante c)
