posts = [("Passas é tudo de bom!", ["Legal", "Bacana"], 5, 2),
         ("E como estarão as famílias neste Natal !?", [":("], 3, 10),
         ("Esta prova está linda!", ["Só leio verdades!", "Isso aí!"], 35, 0)]

somaCurtidas posts = foldl (\ac (_,_,up,down) -> ac + up - down) 0 posts

melhoresPosts posts = filter (\(_, likes) -> likes > 0) $
                      map (\(msg, comment, up, down) -> (msg, up - down)) posts