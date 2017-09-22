package pairless

fun findPairless(a: IntArray): Int? {
    if (! a.isEmpty()) {
        var b: ArrayList<Int> = ArrayList()
        for (x in a) {
            if (! b.contains(x)) {
                b.add(x)
            }
            else {
                b.remove(x)
            }
        }
        if (! b.isEmpty())
        	return b.elementAt(0)
    }
    return null
}

