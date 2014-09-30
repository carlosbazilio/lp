// Immutable map
val langs = Map("Java" -> "Gosling", "Scala" -> "Odersky")
// langs("Lua") = "Ierusalimsky"  // Doesn't change the map
println(langs + (("Lisp", "McCarthy")))

// Mutable map
val capitals = scala.collection.mutable.Map("New York" -> "Albany", "Texas" -> "Austin")
println(capitals)
capitals("Oregon") = "Salem"
println("After change: " + capitals)

