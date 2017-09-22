package maxindex

fun indexOfMax(a: IntArray): Int? {
    var indice = 0
    var maximo = Integer.MIN_VALUE
    var posicao = 0
    if (a.size == 0)
    	return null
    else
    	for (i in a) {
            if (i >= maximo) {
                indice = posicao
                maximo = i
            }
            posicao ++
        }
    return indice
}
