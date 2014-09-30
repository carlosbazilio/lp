import scala.concurrent._
import ExecutionContext.Implicits.global

val primeiraOcorrencia: Future[Int] = future {
	val source = scala.io.Source.fromFile("funcional.scal")
	source.toSeq.indexOfSlice("stockPrice")
}

primeiraOcorrencia onSuccess {
	case valor => println("O valor do indice eh " + valor)
}

primeiraOcorrencia onFailure {
	case t => println("An error has occured: " + t.getMessage)
}

