
def primo(n : Int) : Boolean = {
	var res : Boolean = false
	if (n <= 1)
		res = false
	else
		if (n == 2)
			res = true
		else
			if ((n % 2) == 0)
				res = false
			else
			{
				res = true
				for (i <- 3 to math.sqrt(n).toInt + 1 by 2; if (res))
					if ((n % i) == 0)
						res = false
			}
	res
}

def numPrimos(n : Int) : Int = {
	var qtde : Int = 0
	for (i <- 0 to n)
		if (primo(i))
			qtde = qtde + 1
	qtde
}

var primos = 0

//salva a hora corrente em milisegundos
val inicio = System.currentTimeMillis() 

primos = numPrimos(1000000)

//calcula o tempo de processamento em millisegundos 
val tempoGasto = System.currentTimeMillis() - inicio

println(primos)

println("Tempo: " + tempoGasto)

