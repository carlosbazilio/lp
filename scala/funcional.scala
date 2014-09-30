val tickers = List("AAPL", "AMD", "CSCO", "GOOG", "HPQ", "INTC", 
	"MSFT", "ORCL", "QCOM", "XRX")
	
case class StockPrice(ticker : String, price : Double) {
	def print = println("Top stock is " + ticker + " at price $" + price)
}

def getPrice(ticker : String) = {
 	val url = "http://ichart.finance.yahoo.com/table.csv?s=" + ticker
 	val data = io.Source.fromURL(url).mkString
 	val price = data.split("\n")(1).split(",")(4).toDouble
 	StockPrice(ticker, price)
}

def pickHighPriced(stockPrice1 : StockPrice, stockPrice2 : StockPrice) =
 	if (stockPrice1.price > stockPrice2.price) 
 		stockPrice1
 	else 
 		stockPrice2

def isNotOver500(stockPrice : StockPrice) = stockPrice.price < 500

/////////////////////
// Imperative style

import scala.collection.mutable.ArrayBuffer
 	
val stockPrices = new ArrayBuffer[StockPrice]
for(ticker <- tickers) {
 	stockPrices += getPrice(ticker)
}
 	
for(stockPrice <- stockPrices.reverse) {
 	if(!isNotOver500(stockPrice)) stockPrices -= stockPrice
}
 	
var highestPricedStock = StockPrice("", 0.0)
for(stockPrice <- stockPrices) {
	highestPricedStock = pickHighPriced(highestPricedStock, stockPrice)
}
 	
highestPricedStock print

/////////////////////
// Functional style

//tickers map getPrice filter isNotOver500 reduce pickHighPriced print

