val numeros : List[Int] = List(1, 2, 3)
val numeros2 = List(1, 2, 3)
val numeros3 = List(1, "2", 3)

numeros.foreach { v : Int => println(v) }

numeros2.foreach { v => println(v) }

for (num <- numeros2) { println(num) }

numeros3.foreach { println }

numeros3 foreach println
