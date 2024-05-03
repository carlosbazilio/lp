def fib (x : int) -> int:
    if (x == 1):
        return 0
    if (x == 2):
        return 1
    return fib (x-1) + fib(x-2)

# fib(6)
# fib(5)                        +  fib(4)
# (fib(4)           + fib(3))   +  (fib(3) + fib(2))
# (fib(3) + fib(2)) + 

#print (fib(6))

import sys

print(fib(int(sys.argv[1])))
