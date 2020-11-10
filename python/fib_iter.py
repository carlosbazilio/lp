def fib(n):
    a, b = 0, 1
    while n > 1:
        a, b = b, a+b
        n = n-1
    return a

#print fib (6)

import sys

print fib(int(sys.argv[1]))

