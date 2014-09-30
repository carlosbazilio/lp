/*
Para executar este código:
$ scalac minha-lista-uso.scala minha-lista.scala
$ scala App
*/

/*import wscad2012.scala._
OU
import wscad2012.scala.MinhaLista
import wscad2012.scala.ListaVazia
OU*/
import wscad2012.scala.{MinhaLista, ListaVazia}

object Principal extends App {
	override def main(args: Array[String]) = {
		// Tipo inferido de lista eh ListaVazia !!!
		// Causa erro na chamada do metodo adiciona()
		//var lista = new ListaVazia[String]()
		var lista : MinhaLista[String] = new ListaVazia[String]()

		// Causa excecao na chamada do metodo cabeca, pois a lista ainda esta vazia
		//println("Cabeca da lista: " + lista.cabeca)
		lista = lista.adiciona("Petropolis")
		if (!lista.vazia)
			println("Cabeca da lista: " + lista.cabeca)

		lista = lista.adiciona("Rio das Ostras")
		if (!lista.vazia)
			println("Cabeca da lista: " + lista.cabeca)
	}
}

