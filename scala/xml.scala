val greetingsStr = "<greet>hello</greet>"
println(greetingsStr)
println(greetingsStr.getClass)

// XML as first-class value
val greetings = <greet>hello</greet>
println(greetings)
println(greetings.getClass)
println(greetings.label + ":" + greetings.text)

// XML and pattern matching
greetings match {
 	case <greet>{msg}</greet> => println("found " + msg) //found hello
}

// Using XPath; Note the '\' instead of '/'
val message = <message priority="urgent">avoid ceremony</message>
println("Received " + message \ "@priority" + " message: " + message.text)

val stocksAndPrices =
 	<stocks>
 		<stock symbol="AAPL">302.15</stock>
 		<stock symbol="GOOG">606.20</stock>
 	</stocks>
 	
stocksAndPrices match {
 	case <stocks>{symbolAndPrices @ _*}</stocks> =>
 	println("Found " + symbolAndPrices.size + " children")
 	//Found 5 children: 2 stock elements and 3 empty elements among them
}

stocksAndPrices match {
 	case <stocks>{symbolAndPrices @ _*}</stocks> =>
 		for(symbolAndPrice @ <stock>{price @ _}</stock> <- symbolAndPrices) {
 			println(symbolAndPrice \ "@symbol" + " : " + price)
 		}
}

stocksAndPrices \\ "stock" 
	foreach { symbolAndPrice =>
 		println(symbolAndPrice \ "@symbol" + " : " + symbolAndPrice.text)
 	}

// Building a XML document

val tickers = List("AAPL", "AMD", "CSCO", "GOOG", "HPQ",
 	"INTC", "MSFT", "ORCL", "QCOM", "XRX")
case class StockPrice(ticker : String, price : Double) {
 	def print = println("Top stock is " + ticker + " at price $" + price)
}

def getPrice(ticker : String) = {
 	val url = "http://ichart.finance.yahoo.com/table.csv?s=" + ticker
 	val data = io.Source.fromURL(url).mkString
 	val price = data.split("\n")(1).split(",")(4).toDouble
 	StockPrice(ticker, price)
}

def stockXMLFragment(ticker : String) =
 	<stock ticker={ticker}>{getPrice(ticker).price}</stock>
 	
val stockDocument = <stocks>{tickers map stockXMLFragment}</stocks>

println(stockDocument)
