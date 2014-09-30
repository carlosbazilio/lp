val prices = List(10, 20, 15, 30, 45, 25, 82)

// External iterator
for(price <- prices) { println(price) }

// Internal iterator
//prices.foreach { price => println(price) }
// OU
//prices foreach println

// Element access
println("The fifth element is " + prices(4))
// OU
println("The fifth element is " + prices.apply(4))

// Selects the first price greater than 40
println("First price > 40 is " + prices.find { price => price > 40 })

// Selects all prices greater than 40
println("All prices > 40 are " + prices.filter { price => price > 40 })

// Checks whether any price is greater than 90
println("Any > 90: " + prices.exists { price => price > 90 })

// Checks whether all prices are less than 90
println("All < 90: " + prices.forall { price => price < 90 })

val items = List("A", "B", "C", "D", "E", "F", "G")

// Combines two lists
println("items and prices: " + items.zip(prices))

// Adds a new price
val theNewPricesList = 5 :: prices
println("New: " + theNewPricesList)
println("Old: " + prices)


