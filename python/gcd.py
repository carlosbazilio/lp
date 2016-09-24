def gcd (x, y):
	if (x == y):
		return x
	elif (x > y):
		return gcd (x - y, y)
	else:
		return gcd (x, y - x)

print gcd(15, 10)

