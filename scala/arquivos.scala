import scala.io.Source

object Test {
   def main(args: Array[String]) {
      //println("Following is the content read:" )
      Source.fromFile(args(0)).foreach{ 
			print
      }
   }
}

