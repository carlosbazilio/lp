
def fib (x):
	def fib_aux (x, ant, curr):
	    if (x == 1):
	        return ant
	    return fib_aux (x-1, curr, ant+curr)
	return fib_aux (x, 0, 1)

import sys

print (fib(int(sys.argv[1])))


# fib (4)
# fib_aux (4, 0, 1)
# fib_aux (3, 1, 1)
# fib_aux (2, 1, 2)
# fib_aux (1, 2, 3)
# 
# 0 1 1 2 3 5 8 ...





