import scala.actors.Actor 
import scala.actors.Actor._ 
import java.net.{InetAddress, UnknownHostException}

case class LookupIP(name: String, respondTo: Actor) 
case class LookupResult(name: String, address: Option[InetAddress])

object NameResolver extends Actor { 
	
	def act() { 
		react {
			case LookupIP(name, actor) => 
				actor ! LookupResult(name, getIp(name))
				act()
			case "EXIT" => 
				println("Name resolver exiting.") // quit
			case msg => 
				println("Unhandled message: "+ msg) 
				act()
		}
	}

	def getIp(name: String): Option[InetAddress] = { 
		try {
			Some(InetAddress.getByName(name)) 
		} 
		catch {
			case _:UnknownHostException => None
		}
	}
}

NameResolver.start()
NameResolver ! LookupIP("www.scala-lang.org", self)
println( self.receive { case x => x } )
NameResolver ! LookupIP("www.puro.uff.br", self)
println( self.receive { case x => x } )
//self.react { case x => x }
NameResolver ! "EXIT"


/*
object Principal extends App {

	override def main(args: Array[String]) { 

		println ("Inicio")
		NameResolver.start()
		val id = self
		NameResolver ! ("www.scala-lang.org", id)
		println( id.receive { case x => x } )
		NameResolver ! ("www.puro.uff.br", id)
		println( id.react { case x => x } )
		println ("Fim")

	}
}
*/