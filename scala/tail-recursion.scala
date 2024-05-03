/* This singleton shows that Scala converts tail recursive funcions
to an iterated version. The stack printed by madMethod1 is bigger
than the one printed by madMethod2
*/
// object Sample {
//  	def madMethod1(n : Int) : Int =
//  		if(n == 1) throw new RuntimeException("mad") 
//  		else 1 * madMethod1(n - 1)
//  	//
//  	def madMethod2(n : Int) : Int =
//  		if(n == 1) throw new RuntimeException("mad") 
//  		else madMethod2(n - 1)
//  	//
//  	def main(args : Array[String]) = {
//  		try {
//  			madMethod1(5)
//  		} catch {
//  			case ex => ex.printStackTrace
//  		}
 	
//  		try {
//  			madMethod2(5)
//  		} catch {
//  			case ex => ex.printStackTrace
//  		}
//  	}
// }

// Factorial function tail recursive
// Note the function with two parameters define inside the factorial function
def factorial(n : BigInt) = {

	// Asks the compiler to confirm that the function below is tail recursive	
 	@scala.annotation.tailrec
 	def factorial(fact : BigInt, n : BigInt) : BigInt =
 		if(n == 1) fact 
 		else factorial(fact * n, n - 1)
 	
 	factorial(1, n)
}


