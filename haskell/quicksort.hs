quicksort :: Ord a => [a] -> [a]
quicksort []     = []
quicksort (x:xs) = quicksort [y | y<-xs, y<x ] ++
                             [x              ] ++
                   quicksort [y | y<-xs, y>=x]

quicksortgen [] cmp     = []
quicksortgen (x:xs) cmp = quicksortgen [y | y<-xs, cmp y x] cmp ++
                                       [x              ] ++
                          quicksortgen [y | y<-xs, not(cmp y x)] cmp
