import scala.actors.Futures
val f = Futures.future {
    println("Start: inside block")
    val s = System.currentTimeMillis
    while(System.currentTimeMillis < (s + 1000)) {
        // Simulate computation
    }
    println("Start: end of block")
    42
}
println("After future")
println(f())
println("The end")


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

def opera (i : Int, j : Int, f : (Double, Double) => Double, acum : Double) : Double = {
	var aux = acum
	println ("Thread: " + Thread.currentThread)
	for (k <- i to j)
		aux = f(aux, k)
		//Thread.sleep(50)
	aux
}

import scala.actors.Futures._

def fab() = {
	Time.code { () =>
	val a = future (opera (1, 10000, (x, y) => x + y, 0) )
	val b = future (opera (1, 10000, (x, y) => x * y, 1) )
	a() / b()
	}
}

println( fab() )

