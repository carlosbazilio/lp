import scala.actors.Actor 
import scala.actors.Actor._

val NUM_TRABALHADORES = 8
val QTD_PRIMOS = 1000000

val Coordenador = actor {
	var n, primos, fim_trab = 0
	
	def respondeTrabalhador = {
		if (n <= QTD_PRIMOS)
		{	reply { n }; n = n + 1  }
		else
		{
			reply { -1 }
			fim_trab = fim_trab + 1
			if (fim_trab == NUM_TRABALHADORES)
			{
				println("Primos: " + primos)
				exit
			}
		}
	}
	
	loop {
		react {
			case true => {
				primos = primos + 1
				respondeTrabalhador
			}
			case false | "inicio" => 
				respondeTrabalhador
		}
	}	
}

class Trabalhador(Mestre : Actor) extends Actor {
	def act () {
		var numero = (Coordenador !? "inicio").asInstanceOf[Int]
		//println("Trabalhador iniciou, num inicial: " + numero)
		while (numero != -1) {
			val resultado : Boolean = primo (numero)
			numero = (Coordenador !? resultado).asInstanceOf[Int]
		}
		Mestre ! "fim"
	}
}

def primo2(n : Int) : Boolean = {
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

def primo(n : Int) : Boolean = {
	n match {
		case 0 | 1 => false
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


//var primos = 0

//salva a hora corrente em milisegundos
val inicio = System.currentTimeMillis() 

val t = Array.ofDim[Trabalhador](NUM_TRABALHADORES)
for (i <- 0 to NUM_TRABALHADORES-1) {
	t(i) = new Trabalhador(self)
	t(i).start
}

for (i <- 0 to NUM_TRABALHADORES-1) {
	receive {
		case "fim" =>
	}
}

//calcula o tempo de processamento em millisegundos 
val tempoGasto = System.currentTimeMillis() - inicio

println("Tempo: " + tempoGasto)
