<?php
	function extraiTrecho($string, $trechoInicial, $trechoFinal, $apartir = 0) {
 		$in = stripos($string, $trechoInicial, $apartir) + strlen($trechoInicial);
		$fi = stripos($string, $trechoFinal, $in);
		return array (substr($string, $in, $fi - $in), $fi);
	}

	/*function encontraFechaTag($abretag, $fechatag, $trechopagina) {
		$contatags = 1;
		$inicio = 0;
		$trechoselecionado = "";
		while ($trechoselecionado == "") {
			$posicaoabre = stripos($trechopagina, $abretag, $inicio);
			$posicaofecha = stripos($trechopagina, $fechatag, $inicio);
			if ($posicaofecha < $posicaoabre) && ($contatags == 1)
				$trechoselecionado = substr($trechopagina, 0, $posicaofecha);
			else {
				if ($posicaofecha < $posicaoabre) {
					$contatags--;
					$inicio = $posicaofecha;
				}
				else {
					$contatags++;
					$inicio = $posicaoabre;
				}
			}
		}
		return $trechoselecionado;
	}*/

	function inicializaConexao() {
		return curl_init();
	}

	function encerraConexao($ch) {
		curl_close($ch);
	}

	function obtemPagina($url, $ch) {
		curl_setopt($ch, CURLOPT_URL, $url);
		//curl_setopt($ch, CURLOPT_HEADER, 0);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
		$timeout = 5;
		curl_setopt ($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
		$resultado = curl_exec($ch);
		return $resultado;
	}

	function geraCabecalho($autor) {
		echo "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
		echo "<rss version=\"2.0\">";

		echo "<channel>";
	  	echo "<title>" . ucwords($autor) . " - Estadao</title>";
	  	echo "<link>http://topicos.estadao.com.br/" . $autor . "</link>";
	  	echo "<description>Coluna do " . ucwords($autor) . " - Estadao</description>";
	}

	function geraRodape() {
		echo "</channel></rss>";
	}

	$conexao = inicializaConexao();

	$autor = $_GET["autor"];
	$url = "http://www.estadao.com.br/colunas/" . $autor;

	$homepage = obtemPagina($url, $conexao);

	//geraCabecalho($autor);

  	// Expressao regular para artigos: 
  	// /<a href="(\w|:|\/|\.|,|-)+" class="link-title" >/g

	// Expressão regular para localizar links de artigos de colunas do Estadao
  	if (preg_match_all("/<a href=\"(\w|:|\/|\.|,|-)+\" class=\"link-title\" >/", $homepage, $matches)) {
	    echo "A match was found.";
	} else {
	    echo "A match was not found.";
	}

	echo "\n";

	//var_dump($matches);

	// Obtem a quantidade de links retornados
	$quant_links = count($matches[0]);
	$cont = 0;
	$pos_rel = 0;
	while ($cont < $quant_links) {
		// Retorna o link do artigo e a posicao seguinte, para continuar a busca
		list ($link, $pos_rel) = extraiTrecho($matches[0][$cont], "<a href=\"", "\"", $pos_rel);
		echo $link . "\n";
		// Retorna a pagina do link recuperado
		//$artigo = obtemPagina($link, $conexao);
		//echo $artigo . "\n";
		// Extrai o trecho da pagina que contem o artigo
		//list ($textotags, $pos_rel_artigo) = extraiTrecho($artigo, "<div class=\"n--noticia__content content\">", "<div class=\"n--noticia__fixit\">");
		//echo $textotags . "\n";
		//$trechotexto = encontraFechaTag("<div", "</div", $textotags);
		$cont++;
	}
	

	/* VERSÃO ANTIGA DO ESTADAO

	list ($artigo, $pos) = extraiTrecho($homepage, "<article class=\"artigo\"", "</article>");
	
	$cont = 1;
	while ($cont <= 5) {

		list ($link, $pos_rel) = extraiTrecho($artigo, "<a href=\"", "\"></a>");
		list ($titulo, $pos_rel) = extraiTrecho($artigo, "<h2 class=\"titulo\">", "</h2>");
		list ($resumo, $pos_rel) = extraiTrecho($artigo, "<p>", "...</p>");

		echo "<item>";
		echo "<title>" . $titulo . "</title>";
		echo "<link>" . $link . "</link>";
		echo "<description>" . strip_tags($resumo, '<a>') . "</description>";
		echo "</item>";

		list ($artigo, $pos) = extraiTrecho($homepage, "<article class=\"artigo\"", "</article>", $pos);

		$cont = $cont + 1;
	}*/

	//geraRodape();

	encerraConexao($conexao);
?>



