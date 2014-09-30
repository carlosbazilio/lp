nesimo n [] ret = ret
nesimo 1 (cab:resto) ret = cab
nesimo n (cab:resto) ret = nesimo (n-1) resto ret

matriz x y mat =
	nesimo y (nesimo x mat []) (-1)

--main = print (matriz 2 3 [[1, 2, 3], [1, 2, 4], [1, 2, 3]])
--main = print (nesimo 2 [[1, 2, 3], [1, 2, 4], [1, 2, 3]] [])
--main = print (nesimo 2 [1, 2, 3] 0)
--main = print (type nesimo)
