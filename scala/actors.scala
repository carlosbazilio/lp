import scala.actors.Actor 
import scala.actors.Actor._

/*
class Fussy extends Actor { 
	def act() {
		loop {
			receive { 
				case s: String => println("I got a String: " + s) 
				case i: Int => println("I got an Int: " + i.toString) 
				case _ => println("I have no idea what I just got.")
			}
		}
	}
}

val fussyActor = new Fussy()

NAO ESTA FUNCIONANDO !!!
*/

val fussyActor = actor { 
	val valor = 10;
	loop {
		receive { 
		//react {
			case s: String => println("I got a String: " + s) 
			case i: Int => println("I got an Int: " + i.toString) 
			case _ => println("I have no idea what I just got.")
		}
		println("Trecho final do ator, valor = " + valor)
	}
}

/*	
object Principal extends App {

override def main(args: Array[String]) { 

fussyActor ! "hi there" 
fussyActor ! 23 
fussyActor ! 3.33

}

}
*/

