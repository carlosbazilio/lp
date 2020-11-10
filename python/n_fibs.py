def nfibs(n, fibs = []):
    a, b = 0, 1
    while n > 1:
        fibs.append(a)
        a, b = b, a+b
        n = n-1
    fibs.append(a)
    return fibs

import sys

print nfibs(int(sys.argv[1]))

