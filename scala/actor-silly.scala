import scala.actors._

object SillyActor extends Actor { 
	def act() {
		//receiveWithin (1000) {
		//receive {
		react {
			case "FIM" =>
			case msg => {
				println ("Mensagem recebida: " + msg + " Thread: " + Thread.currentThread)
				act()
			}
		}
	}
}

SillyActor.start()
//Thread.sleep(2000) TIMEOUT
SillyActor ! "Ola !!!"
SillyActor ! "Ola 2 !!!"
SillyActor ! "Ola 3 !!!"
SillyActor ! "Ola 4 !!!"
SillyActor ! "FIM"

