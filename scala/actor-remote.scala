import scala.actors._
import scala.actors.Actor._
import scala.actors.remote._
import scala.actors.remote.RemoteActor._

class MyActor extends Actor {
	def act() {
		alive(9000)
		register('myActor, self)
		receive {
	 		case msg => println("Resposta remota: " + msg)
		}
	}
}

