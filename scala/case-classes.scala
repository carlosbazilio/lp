case class Sell(symbol : String, quantity : Int)
case class Buy(symbol : String, quantity : Int)

def processTrade(trade : Any) {
 	trade match {
 		case Sell(symbol, quantity) => 
 			println("Selling " + quantity + " stocks of " + symbol)
		case Buy(symbol, quantity) if (quantity > 1000) =>
 			println("Buying lots..." + quantity + " stocks of " + symbol)
 		case Buy(symbol, quantity) =>
 			println("Buying " + quantity + " stocks of " + symbol)
 	}
}
 	
processTrade(Sell("AAPL", 200)) // Selling 200 stocks of AAPL
processTrade(Buy("AAPL", 2000)) // Buying lots...2000 stocks of AAPL
processTrade(Buy("GOOG", 200)) // Buying 200 stocks of GOOG

