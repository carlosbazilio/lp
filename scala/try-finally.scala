class Resource private {
 	println("Creating Resource")
 	
 	def someop1() { println("someop1") }
 	def someop2() { println("someop2") }
 	
 	private def close() { println("cleaning-up...") }
}

object Resource {
 	def use[T](block : Resource => T) = {
 		val resource = new Resource
 		try {
 			block(resource)
 		} finally {
 			resource.close()
 		}
 	}
}

Resource.use { resource =>
 	resource.someop1()
 	resource.someop2()
}

//Creating Resource
//someop1
//someop2
//cleaning-up

