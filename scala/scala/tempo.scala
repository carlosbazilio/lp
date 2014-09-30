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

//Time.code { () => Thread.sleep(1000) }

val names = List("Jane", "Jacob", "Brenda", "Brad")
//println(names)
//println(names.par)

def checkStatus(name : String) = {
 	Thread.sleep(500) //simulate the delay to communicate
 	println(name)
 	String.format("%s's status", name)
}

/*
Time.code { () => println(names.map { checkStatus }) }

println("Parallel version: "); 
Time.code { () => println(names.par.map { checkStatus }) }
*/

def isConnected(name : String) = {
 	Thread.sleep(1000) //simulate the delay to communicate
 	name.length > 4 //simulated response
}

/*
Time.code { () => println("All connected? :" + names.forall { isConnected }) }

println("Parallel version: "); 
Time.code { () => println("All connected? :" + names.par.forall { isConnected }) }

*/

Time.code { () =>
 	println("A connected person: " + names.find { isConnected })
}

Time.code { () =>
 	println("A parallel connected person: " + names.par.find { isConnected })
}


