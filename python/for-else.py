def primos (k):
	for n in range(2, k):
	    for x in range(2, n):
	        if n % x == 0:
	            print(n, 'e divisivel por', x, ' => ', n/x)
	            break
	    else: 
	    	print(n, 'e primo!')

primos(15)
