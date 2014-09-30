class Marker private (val color : String) {
	println("Creating marker of color " + color)
}
 
object Marker {
	val markers = scala.collection.mutable.Map[String, Marker]()
	def create(color : String) = {
		if (!markers.contains(color)) {
			markers(color) = new Marker(color)
		}
		markers(color)
	}
}

println(Marker.create("Red").color)
println(Marker.create("White").color)
println(Marker.create("Blue").color)
println(Marker.create("Red").color)

// Construtor Marker não pode ser acessado daqui
val d = new Marker("Red")
println(d)

