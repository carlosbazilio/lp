import scala.io._
import scala.util.matching.Regex
import java.io.IOException

object Crawler {
	def getLinks (url : String) = {
		val regex = new Regex("http(s)?://(\\w+\\.)*(\\w+)(:\\d+)?")
		var links = List[String]()
		try {
			val conteudo = Source.fromURL(url).mkString
			links = regex.findAllIn(conteudo).toList
		} catch {
			case ex: IOException => {
		    	println("Erro ao processar url: " + url)
		 	}
		}
		links
	}
}

// Link inicial
var links = List(args(0))
// Profundidade da busca (quantidade de links)
var qtd_acessos = args(1).toInt;
while (links.size > 0 && qtd_acessos > 0) {
	val link = links.head
	println("Processando: " + link)
	links = (links.tail ++ Crawler.getLinks(link)).distinct
	qtd_acessos = qtd_acessos - 1
}

println("Resultado: ")
links.distinct.foreach { println }
//links.foreach { println }

