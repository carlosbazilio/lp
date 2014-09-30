import scala.actors.Actor 
import scala.actors.Actor._
import scala.concurrent._

val NUM_TRABALHADORES = 8
val QTD_PRIMOS = 1000000
val TIMEOUT = 5000
val TAM_BOLSA = 20

var gNumero = new SyncVar[Int]()
var gPrimos = new SyncVar[Int]()

val Coordenador = actor {
	for (i <- QTD_PRIMOS to (0-(NUM_TRABALHADORES*TAM_BOLSA)) by -(TAM_BOLSA)) {
		gNumero.put(i)
	}
}

class Trabalhador(n : SyncVar[Int], p : SyncVar[Int], Mestre : Actor) extends Actor {
	def act () {
		var numero = n.take(TIMEOUT)
		var primos : Int = 0
		while (numero >= 0) {
			val resultado = n_primo (numero)
			if (resultado._1) {
				primos = p.take(TIMEOUT)
				p.put(primos + resultado._2)
			}
			numero = n.take(TIMEOUT)
		}
		Mestre ! "fim"
	}
}

def n_primo(n : Int) : (Boolean, Int) = {
	var ehPrimo = false
	var qtdPrimos = 0
	for (i <- n until (n - TAM_BOLSA) by -1) {
		ehPrimo = primo(i)
		if (ehPrimo) {
			qtdPrimos = qtdPrimos + 1
			ehPrimo = false
		}
	}
	(qtdPrimos > 0, qtdPrimos)
}

def primo(n : Int) : Boolean = {
	n match {
		case n if n <= 1 => false
		case 2 => true
		case n if (n % 2) == 0 => false
		case _ => {
			var res = true
			for (i <- 3 to math.sqrt(n).toInt + 1 by 2; if (res))
				if ((n % i) == 0)
					res = false
			res
		}
	}
}

//salva a hora corrente em milisegundos
val inicio = System.currentTimeMillis() 

gPrimos.put(0)

val t = Array.ofDim[Trabalhador](NUM_TRABALHADORES)
for (i <- 0 to NUM_TRABALHADORES-1) {
	t(i) = new Trabalhador(gNumero, gPrimos, self)
	t(i).start
}

for (i <- 0 to NUM_TRABALHADORES-1) {
	receive {
		case "fim" =>
	}
}

//calcula o tempo de processamento em millisegundos 
val tempoGasto = System.currentTimeMillis() - inicio

println("Primos: " + gPrimos.take(TIMEOUT))
println("Tempo: " + tempoGasto)
