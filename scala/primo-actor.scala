import scala.actors.Actor 
import scala.actors.Actor._ 

def primo(n : Int) : Boolean = {
	var res : Boolean = false
	//println("n = " + n + " Id = " + Thread.currentThread().getId())
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
	val mestre = self
	var qtde : Int = 0
	for (i <- 0 to n)
		actor {
			mestre ! primo(i)
		}
	for (i <- 0 to n)
		receive {
			case true => qtde = qtde + 1
			case _ =>
		}
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

