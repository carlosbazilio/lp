
fun main(args: Array<String>) {
    println("Alo Mundo!")
    // var c : Desenhavel
    // c = Circulo(10, "vermelha", true, 0, 0)
    // var r : Desenhavel
    // r = Retangulo(20, 30, "azul", false, 0, 0)
    var c = Circulo(10, "vermelha", true, 0, 0)
    var r = Retangulo(20, 30, "azul", false, 0, 0)
    var figuras = listOf(c, r)
    // var figuras : List<Desenhavel> 
    // figuras = listOf(c, r)
    for (fig in figuras) {
        fig.mover(-10, -10)
        fig.desenhar() // Polimorfismo !!!
    }
}
