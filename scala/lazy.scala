def isPrime(number : Int) = {
 	val sqrtOfNumber = math.sqrt(number).toInt
 	val hasFactorsOtherThan1AndItself = (2 to sqrtOfNumber).exists { i => number % i == 0 }
 	number > 1 && !hasFactorsOtherThan1AndItself
}

/* It will loop forever !!
def primes(number : Int) : List[Int] = {
 	if (isPrime(number)) 
 		number :: primes(number + 1)
 	else 
 		primes(number + 1)
}*/

// Type Stream allows a lazy evaluation
def primes(number : Int) : Stream[Int] = {
 	if (isPrime(number)) 
 		number #:: primes(number + 1) 
 	else 
 		primes(number + 1)
}
 	
println(primes(1).take(10).toList)

//////////////////////////////////////
// Another example

val names = List("Steve", "Susan", "Mac", "Brad", "Gill")
 	
def len(n : String) = {
 	println("Len for " + n)
 	(n, n.length)
}

println(names map len find { e => e._2 == 3 })

// The view call turns list names into a lazy collection
println(names.view map len find { e => e._2 == 3 })


