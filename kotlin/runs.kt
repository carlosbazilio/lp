package runs

fun runs(a: IntArray): Int {
    var corrente : Int
    var numRuns = 0
    if (a.size > 0) {
        numRuns = 1
        corrente = a[0]
        for (i in a) {
            if (i != corrente) {
            	numRuns++
                corrente = i
            }
        }
    }
    return numRuns
}
