
def fatorial(n : Int) : Int = {
	var res : Int = 1
	if (n >= 1)
		res = n * fatorial(n - 1)
	res
}

def fatorial2(n : Int) = {
	var res = 1
	if (n >= 1)
		res = n * fatorial(n - 1)
	res
}

println("Fatorial de 10 e ", fatorial(4))

