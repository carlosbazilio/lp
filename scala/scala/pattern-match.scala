val coins = List(25, 10, 5, 10, 5, 25, 10, 5, 5, 25)

/* Traditional if-else construct
def countCoins(coins : Seq[Int], nickels : Int = 0,
 	dimes : Int = 0, quarters : Int = 0) : Map[String, Int] = {
 	
 	if (coins.isEmpty)
 		Map("nickels" -> nickels, "dimes" -> dimes, "quarters" -> quarters)
 	else {
 		if (5 == coins.head) {
 			countCoins(coins.tail, nickels + 1, dimes, quarters)
 		}
 		else {
 			if (10 == coins.head) {
 				countCoins(coins.tail, nickels, dimes + 1, quarters)
 			} else {
 				if (25 == coins.head) {
 					countCoins(coins.tail, nickels, dimes, quarters + 1)
 				} else {
 					countCoins(coins.tail, nickels, dimes, quarters)
 				}
 			}
 		}
 	}
}

println(countCoins(coins))*/

def countCoins(coins : Seq[Int], nickels : Int = 0,
	dimes : Int = 0, quarters : Int = 0) : Map[String, Int] = {

	coins match {
 		case Seq() =>
 			Map("nickels" -> nickels, "dimes" -> dimes, "quarters" -> quarters)
 		case _ =>
 			coins.head match {
 				case 5 => countCoins(coins.tail, nickels + 1, dimes, quarters)
	 			case 10 => countCoins(coins.tail, nickels, dimes + 1, quarters)
 				case 25 => countCoins(coins.tail, nickels, dimes, quarters + 1)
 				case _ => countCoins(coins.tail, nickels, dimes, quarters)
 			}
	}
}

def countCoins2(coins : Seq[Int], nickels : Int = 0,
	dimes : Int = 0, quarters : Int = 0) : Map[String, Int] = {

	coins match {
 		case Seq() => Map("nickels" -> nickels, "dimes" -> dimes, "quarters" -> quarters)
 		case Seq(5, _*) => countCoins2(coins.tail, nickels + 1, dimes, quarters)
 		case Seq(10, _*) => countCoins2(coins.tail, nickels, dimes + 1, quarters)
 		case Seq(25, restOfTheCoins @ _*) => 
 			countCoins2(restOfTheCoins, nickels, dimes, quarters + 1)
 		case _ => countCoins2(coins.tail, nickels, dimes, quarters)
 	}
}

println(countCoins2(coins))

// Matching different types

def process(message : Any) = {
 	message match {
 		case "hello" => println("received hello")
 		case x : String => println("received a string " + x)
 		case (a, b) => println("received tuple (" + a + ", " + b + ")")
 		case 22 => println("received 22")
 		case x : Int if x < 0 => println("received a negative number " + x)
 		case y : Int => println("received number " + y)
 		case l : List[Int] => println("received list with size " + l.length)
		case _ => println("pattern not recognized!")
 	}
}

process(1, 2) // received typle (1, 2)
process("hello") // received hello
process("test") // received a string test
process(22) // received 22
process(12) // received number 12
process(-32) // received a negative number -32
process(15.8) // pattern not recognized!
process(List(1, 2, "3"))



