-- 2.a)
dupli [] = []
dupli (c : resto) = (c : (c : (dupli resto)))

-- 2.b)
repli [] _ = []
repli l 0 = []
repli l 1 = l
repli (c : resto) n = (nplica c n) ++ (repli resto n)
nplica c 0 = []
nplica c x = (c : (nplica c (x - 1)))

-- 2.c)
insiraEm l v 1 = (v : l)
insiraEm [] v _ = []
insiraEm (c : resto) v n = (c : (insiraEm resto v (n - 1)))

-- 2.d)
-- rotate ['a','b','c','d','e','f','g','h'] 3 = "defghabc"
rotate [] x = []
rotate l 0 = l
rotate l x = rotate_aux l [] x
rotate_aux l laux 0 = l ++ laux
rotate_aux (c:resto) laux x = rotate_aux resto (laux ++ [c]) (x - 1)

-- 3.a)
soma [] [] = []
soma pol1 pol2 = soma_aux pol1 pol2 pol2
soma_aux ((b1,p1):r1) [] pol2bk = ((b1,p1) : (soma_aux r1 pol2bk pol2bk))
soma_aux ((b1,p1):r1) ((b2,p2):r2) pol2bk
	| (p1 == p2) = (((b1+b2),p1) : (soma_aux r1 r2 pol2bk))
	| otherwise = soma_aux ((b1,p1):r1) r2 pol2bk

-- 3.b)
elev x 0 = 1
elev x y = x * (elev x (y - 1))
avalia_pol [] x = 0
avalia_pol ((b,p):r) x = (b * (elev x p)) + (avalia_pol r x)

