def fatorial (x : Int) = {
	def fatorial (x : Int, acum : Int) : Int = if (x <= 1) acum else fatorial (x-1, acum*x)
	fatorial (x, 1)
}

 