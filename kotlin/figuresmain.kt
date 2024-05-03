
fun main(args: Array<String>) {
    val circ1 = Circulo(5, "amarela", true, 0, 0)
    val ret1 = Retangulo(4, 3, "azul", false, 0, 0)
    val objetoQQ = "teste"
    val circ2 = Circulo(7, "verde", true, 0, 0)

    ret1.cor = "vermelha"
    // ret1.pos_x = 10
    // ret1.pos_y = 20
    ret1.mover(10, 20)

    val figuras : List<Figura>
    figuras = listOf<Figura>(circ1, ret1)
    for (f in figuras) {
        println("Desenhar():")
        f.desenhar()
        println("toString():")
        println(f.toString())
    }
}
