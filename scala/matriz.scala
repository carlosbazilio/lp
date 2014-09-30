import scala.actors._
import scala.actors.Futures._

def mult_matrizes(m1: Array[Array[Float]], m2: Array[Array[Float]]): Array[Array[Float]] = {
	var m3 = Array.ofDim[Float](m1.length,m2(0).length)
	
	if (m1(0).length == m2.length) {
		for (i <- 0 to m1.length - 1) {
			for (j <- 0 to m2(0).length - 1)
				for (k <- 0 to m2.length - 1)
					m3(i)(j) = m3(i)(j) + m1(i)(k)*m2(k)(j)
		}
	}
	m3
}

def aleatorio(m: Int, n: Int): Array[Array[Float]] = {
	var matriz = Array.ofDim[Float](m,n)
	
	for (i <- 0 to m - 1)
		for (j <- 0 to n - 1)
			matriz(i)(j) = Math.random.toFloat
	matriz
}

def fromFile(arquivo : String): Array[Array[Float]] = {
	val linhas = scala.io.Source.fromFile(arquivo).getLines
	
	// 1a linha: Dimensao da matriz
	val cabecalho = linhas.next.split(" ")
	val m = cabecalho(0).toInt
	val n = cabecalho(1).toInt
	var matriz = Array.ofDim[Float](m, n)
	
	for (linha <- linhas; i <- 0 to m - 1) {
		matriz(i) = linha.split(" ").map(_ toFloat)
	}
				
	matriz
}

import java.io._

def toFile(caminho : String, m : Array[Array[Float]]) = {
	val saida = new PrintWriter(new File(caminho))
	val cabecalho : String = m.length + " " + m(0).length + "\n"
	saida write cabecalho
	saida write geraString (m)
	saida close
}

def geraString(m: Array[Array[Float]]) = {
	var res = ""
	for (i <- 0 to m.length - 1) {
		for (j <- 0 to m(0).length - 1) {
			res = res + m(i)(j) + " "
		}
		res = res + "\n"
	}
	res
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

//val A: Array[Array[Float]] = Array(Array(1, 2, 3), Array(4, 5, 6))
//val B: Array[Array[Float]] = Array(Array(7, 10, 13), Array(8, 11, 14), Array(9, 12, 15))

//val A = aleatorio(500,500)
//val B = aleatorio(500,500)

val A = fromFile("/Users/carlosbazilio/Aulas/PURO/LP/C/multmat/entradas/A512x512.txt")
val B = fromFile("/Users/carlosbazilio/Aulas/PURO/LP/C/multmat/entradas/A512x512.txt")

//println( toString(mult_matrizes(A, B)) )

var C : Array[Array[Float]] = null

Time.code { () =>
	C = mult_matrizes(A, B)
}

toFile("/Users/carlosbazilio/Aulas/PURO/LP/C/multmat/saidas/A512x512.txt", C)

