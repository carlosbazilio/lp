def timeMethod (method : (Any*) => Unit) = {
	val start = System.nanoTime
	method()
	val end = System.nanoTime
	(end - start)/10000000000.0
}

def sumOfFactors(number: Int) = {
	(0 /: (1 to number)) { (sum, i) => if (number % i == 0) sum + i else sum }
}

def isPerfect(candidate: Int) = { 2 * candidate == sumOfFactors(candidate) }

def isPerfect2() = { println (2 * 6 == sumOfFactors(6)) }


var x = null
timeMethod(isPerfect2)
println("6 is perfect? " + isPerfect(6)) 
println("33550336 is perfect? " + isPerfect(33550336)) 
println("33550337 is perfect? " + isPerfect(33550337))

