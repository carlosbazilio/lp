import scala.io._
import scala.util.matching.Regex

object Crawler {
	def getLinks (url : String) = {
		val regex = new Regex("http://(\\w+\\.)*(\\w+)(\\d*)?")
		val conteudo = Source.fromURL(url).mkString
		regex.findAllIn(conteudo)
	}
}

val links = Crawler.getLinks(args(0))
links.foreach { println }

