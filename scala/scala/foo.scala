// Para executar:
// scalac foo.scala Bar.java
// javac -classpath /usr/local/scala/lib/scala-library.jar:./ Bar.java
// scala Principal

class Foo
 
class Baz extends Bar {
	println("Construtor de Baz")
}

object Principal extends App {
	override def main(args: Array[String]) { 
		val b = new Baz
	}
}
