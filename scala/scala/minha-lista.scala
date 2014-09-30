package wscad2012.scala

abstract class MinhaLista[A] {
	def vazia: Boolean 
	def cabeca: A
	def corpo: MinhaLista[A]
	def adiciona (e: A): MinhaLista[A] = new Lista[A](e, this)
}

class ListaVazia[A] extends MinhaLista[A] {
	def vazia = true
	def cabeca = error("Metodo cabeca() aplicado a lista vazia!") 
	def corpo = error("Metodo corpo() aplicado a Lista Vazia!") 
}

class Lista[A](elem: A, resto: MinhaLista[A]) extends MinhaLista[A] {
	def vazia = false
	def cabeca = elem
	def corpo = resto
}

/*
object App extends Application {
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
*/
