import scala.io._
import scala.util.matching.Regex

object Crawler {
	def getPageSize (url : String) =
		Source.fromURL(url).mkString.length
	
	def getLinks (url : String) =
		new Regex("http://(\\w+\\.)*(\\w+)(\\d*)?").findAllIn(Source.fromURL(url).mkString)
		
	def getLinks2 (url : String) = {
		val regex = new Regex("http://(\\w+\\.)*(\\w+)(\\d*)?")
		val conteudo = Source.fromURL(url).mkString
		regex.findAllIn(conteudo)
	}
	
	def getXML (url : String) = {
		//val regex = new Regex("http://(\\w+\\.)*(\\w+)(\\d*)?")
		val conteudo = Source.fromURL(url).mkString
		scala.xml.XML.loadString(conteudo)
	}
	
	def getSource (url : String) = Source.fromURL(url).mkString
	
	def getPosts (conteudo : String) {
		val posts = new scala.util.matching.Regex("<span class=\"linha-fina\"><a href=\"(/\\w+|,(\\w|-)+|(.\\w)*)*\" title=\"(\\w+|\\s+|[-,!.]|[\\p{L}])*").findAllIn(conteudo)
		posts.foreach { println }
	}
	
	def getPositionCloseMarkup (conteudo : String, trechoHtml : String) = {
		var divs = 1
		//var posIni = conteudo.indexOf("<div class=\"resultado\">")
		val tag = trechoHtml.trim().split(" ")(0).substring(1)
		val endTag = "</" + tag + ">"
		val begTag = "<" + tag
		var posIniHtml = conteudo.indexOf(trechoHtml)
	}
}

/*val links = Crawler.getLinks2(args(0))
links.foreach { println }*/

Crawler.getPosts(Crawler.getSource(args(0)))

