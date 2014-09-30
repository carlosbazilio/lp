/* def soma (x : Int)(y : Int) = {
	x + y
}

def soma5 = soma(5) _

println(soma5(20))

def inc2 = { x : Int => x + 1 }

def cte = { "x" }

def cte2 = { _ : Any => "x" }

println (inc2(10))

println (cte)

println (cte2(1, 2))

def f = 10

def fwhile (cond: => Boolean)(corpo: => Unit) : Unit = {
	if (cond) {
		corpo
		fwhile(cond)(corpo)
	}
}

var i = 5
fwhile (i > 0) {
	println("Hello nro: " + i + "!!")
	i = i - 1
}

def tam[T](l : Array[T]) = {
	var cont = 0
	for (elem <- l)
		cont = cont + 1
	cont
}

println(tam [Int](Array(1, 2, 4)))

def fat (x : Int) = {
	(1 to x) reduceLeft {_ * _}
}

println(fat(5))

List(1, 2, 3) map { _ + 1 }

List("a", "abc", "abcdef") map { _.length }

List("a", "abc", "abcdef") filter { _.length >= 3 }

List("a", "abc", "abcdef") map { _.length } reduceLeft { _ + _ }

def f1 () = { println("Ola F1!") }
f1

val f2 = { println("Ola F2!") }
f2

val second: List[Int] => Int = { 
	case x :: y :: _ => y
	case _ => 0
}

println (second(List(1, 2, 3)))
//println (second(List(1)))

def fsecond: List[Int] => Int = { 
	case x :: y :: _ => y
	case _ => 0
}

def fsecond2: PartialFunction[List[Any], Any] = { 
	case x :: y :: _ => y
}

println (fsecond2(List(1)))
*/

def bloco() = {
	val cte = 5
	println("Comeco da funcao !!")
	def localf() = {
		(cte*cte)
	}
	for (i <- 1 to 3)
		println ("Valor (" + i*localf() + ")")
}

bloco

/*for (j <- 1 to 3)
	bloco
*/
