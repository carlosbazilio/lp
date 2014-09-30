// Parameter functions
def sum(f: Int => Int, a: Int, b: Int): Int = 
	if (a > b) 0 else f(a) + sum(f, a + 1, b)
	
def sumInts(a: Int, b: Int): Int = sum(id, a, b) 
def sumSquares(a: Int, b: Int): Int = sum(square, a, b) 
def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)

def id(x: Int): Int = x 
def square(x: Int): Int = x * x 
def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

// Anonymous parameter functions
def sumIntsAnonymous(a: Int, b: Int): Int = sum((x: Int) => x, a, b) 
def sumSquaresAnonymous(a: Int, b: Int): Int = sum((x: Int) => x * x, a, b)

def sumIntsAnonymous2(a: Int, b: Int): Int = sum(x => x, a, b) 
def sumSquaresAnonymous2(a: Int, b: Int): Int = sum(x => x * x, a, b)

// Functions that return other functions
def sumCurried(f: Int => Int): (Int, Int) => Int = { 
	def sumF(a: Int, b: Int): Int =
		if (a > b) 0 
		else f(a) + sumF(a + 1, b) 
	sumF
}

def sumIntsCurried = sumCurried(x => x) 
def sumSquaresCurried = sumCurried(x => x * x) 
def sumPowersOfTwoCurried = sumCurried(powerOfTwo)

/* OU
val sumInts = sum(x => x) 
val sumSquares = sum(x => x * x) 
val sumPowersOfTwo = sum(powerOfTwo)
*/

def sumCurried2(f: Int => Int)(a: Int, b: Int): Int = 
	if (a > b) 0 
	else f(a) + sumCurried2(f)(a + 1, b)

println(sumCurried2(x => x)(1,5))
