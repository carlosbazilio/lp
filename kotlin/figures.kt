interface Desenhavel {
    fun desenhar()
    fun mover(x : Int, y : Int)
}

abstract class Figura (
    val cor : String,
    var preenchida : Boolean,
    protected var pos_x : Int,
    protected var pos_y : Int) : Desenhavel { 

    override fun mover(x : Int, y : Int) {
        if ((pos_x + x) > 0)
            pos_x += x
        if ((pos_y + y) > 0)
            pos_y += y
    }
}

class Circulo (
    var raio : Int,
    cor : String, 
    preenchida : Boolean, 
    pos_x : Int, 
    pos_y : Int) : Figura (cor, preenchida, pos_x, pos_y) {

    override fun desenhar() {
        println("Circulo com raio " + raio + " e posição " + pos_x + " e " + pos_y)
    }
}

class Retangulo (
    var lado1 : Int,
    var lado2 : Int,
    cor : String, 
    preenchida : Boolean, 
    pos_x : Int, 
    pos_y : Int) : Figura (cor, preenchida, pos_x, pos_y) {

    override fun desenhar() {
        println("Retângulo com lados $lado1 e $lado2 na posição $pos_x e $pos_y")
    }
}

