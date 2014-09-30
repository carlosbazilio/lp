import scala.actors._

class Conta (val id : Int, val nome : String, var saldo : Float = 0)

object SillyActor extends Actor { 
	var c1 = new Conta(1, "Bazilio")
	var c2 = new Conta(2, "Silvana")
	var c3 = new Conta(3, "Noemi")
	var lista = List(c1, c2, c3)
	def act() {
		receive {
			case "Inicia" => {
				SillyActor2 ! lista
				act()
			}
			case x : List[Conta] => {
				println ("Saldo recebido por Silly1: " + x(0).saldo)
				println ("Saldo original na lista em Silly1: " + lista(0).saldo)
				println ("Saldo original na variavel em Silly1: " + c1.saldo)
			}
		}
	}
}

object SillyActor2 extends Actor {
	def act() {
		receive {
			case x : List[Conta] => {
				println ("Saldo do 1o. elemento em Silly2: " + x(0).saldo)
				// Adiciona 1000 a cada objeto da lista
				x.foreach( x => x.saldo = x.saldo + 1000)
				println ("Saldo alterado 1o. elemento em Silly2: " + x(0).saldo)
				SillyActor ! x
			}
		}
	}
}

SillyActor.start()
SillyActor2.start()
SillyActor ! "Inicia"

