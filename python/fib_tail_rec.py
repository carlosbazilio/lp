
def fib (x):
	def fib_aux (x, ant, curr):
	    if (x == 1):
	        return ant
	    return fib_aux (x-1, curr, ant+curr)
	return fib_aux (x, 0, 1)

import sys

print (fib(int(sys.argv[1])))
