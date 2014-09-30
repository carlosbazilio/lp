val prices = List(10, 20, 15, 30, 45, 25, 82)

def totalPrices(prices : List[Int]) = {
	prices.foldLeft(0) { (total, price) => total + price }
}

println("Total of prices is " + totalPrices(prices))

def totalSelectPrices(prices : List[Int], selector : Int => Boolean) = {
 	prices.foldLeft(0) { (total, price) =>
 		if (selector(price)) 
 			total + price 
 		else 
 			total
 	}
}

println("Total of prices is " + totalSelectPrices(prices, { price => true }))
println("Total of prices is " + totalSelectPrices(prices, { _ => true }))

def greater40 (v : Int) = v > 40
println("Total of prices over 40 is " + totalSelectPrices(prices, greater40))

println("Total of prices over 40 is " + totalSelectPrices(prices, { price => price > 40 }))

// Multiple parameter list
def totalSelectPrices2(prices : List[Int]) (selector : Int => Boolean) = {
 	prices.foldLeft(0) { (total, price) =>
 		if (selector(price)) 
 			total + price 
 		else 
 			total
 	}
}

println("Total of prices over 40 is " + totalSelectPrices2(prices) { price => price > 40 })
