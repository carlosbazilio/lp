package sum

fun sum(a: IntArray): Int {
    // Write your solution here
    var s : Int = 0
    for (i in a)
    	s = s + i
    return s
}

