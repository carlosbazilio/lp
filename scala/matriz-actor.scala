import scala.actors._
import Actor._

def mult_matrizes(m1: Array[Array[Double]], m2: Array[Array[Double]]): Array[Array[Double]] = {
	val mestre = self
	var m3 = Array.ofDim[Double](m1.length,m2(0).length)
	
	if (m1(0).length == m2.length) {
		for (i : Int <- 0 to m1.length - 1) {
			actor {
				for (j <- 0 to m2(0).length - 1)
					for (k <- 0 to m2.length - 1)
						m3(i)(j) = m3(i)(j) + m1(i)(k)*m2(k)(j)
				//println("Envio de " + i)
				mestre ! i
			}
		}
	
		for (i <- 0 to m1.length - 1) {
			receive {
				case ind : Int => {
					//println("Recebimento de " + ind)
				}
				case _ => println ("Caso nao previsto!")
			}
		}
	}
	
	m3
}

def aleatorio(m: Int, n: Int): Array[Array[Double]] = {
	var matriz = Array.ofDim[Double](m,n)
	
	for (i <- 0 to m - 1)
		for (j <- 0 to n - 1)
			matriz(i)(j) = Math.random
	matriz
}

def toString(m: Array[Array[Double]]) = {
	for (i <- 0 to m.length - 1) {
		for (j <- 0 to m(0).length - 1) {
			print(m(i)(j) + " ")
		}
		println
	}
}

object Time {
 	def code(block: () => Unit) = {
 		val start = System.nanoTime
 		try {
 			block()
 		} finally {
 			val end = System.nanoTime
 			println("Time taken: " + (end - start)/1.0e9)
 		}
 	}
}

//val A: Array[Array[Double]] = Array(Array(1, 2, 3), Array(4, 5, 6))
//val B: Array[Array[Double]] = Array(Array(7, 10, 13), Array(8, 11, 14), Array(9, 12, 15))

val A = aleatorio(500,500)
val B = aleatorio(500,500)

//println( toString(mult_matrizes(A, B)) )

Time.code { () =>
	mult_matrizes(A, B)
}
