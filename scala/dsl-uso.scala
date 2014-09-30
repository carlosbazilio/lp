
/*
* Compilacao: scalac dsl.scala dsl-uso.scala
* Execucao no prompt: $ scala Principal
* Execucao no shell: scala> :cp <dir> //inclui diretorio onde as classes compiladas estao no classepath)
* 					 scala> import DateHelper._ //importa a classe definida
*					 scala> 2 days ago
*/

import DateHelper._

object Principal extends App {
	override def main(args: Array[String]) = {
		val past = 2 days ago 
		val appointment = 5 days from_now
		println("Past: " + past) 
		println(appointment)
		println(today)
		println(tomorrow)
		println(yesterday)
	}
}

