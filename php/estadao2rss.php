<?php

	function extraiTrecho($string, $trechoInicial, $trechoFinal, $apartir = 0) {
 		$in = stripos($string, $trechoInicial, $apartir) + strlen($trechoInicial);
		$fi = stripos($string, $trechoFinal, $in);
		return array (substr($string, $in-1, $fi - $in), $fi);
	}

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
		echo "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
		echo "<rss version=\"2.0\">";

		echo "<channel>";
	  	echo "<title>" . ucwords($autor) . " - Estadao</title>";
	  	echo "<link>http://topicos.estadao.com.br/" . $autor . "</link>";
	  	echo "<description>Coluna do " . ucwords($autor) . " - Estadao</description>";
	}

	function geraItem($titulo, $link, $conteudo) {
		echo "<item>";
		echo "<title>" . $titulo . "</title>";
		echo "<link>" . $link . "</link>";
		echo "<description>" . $conteudo . "</description>";
		echo "</item>";
	}

	function geraRodape() {
		echo "</channel></rss>";
	}

	$conexao = inicializaConexao();

	// Do browser
	//$autor = $_GET["autor"];
	// Da linha de comando
	$autor = $argv[1];
	$url = "https://cultura.estadao.com.br/colunas/" . $autor;

	$homepage = obtemPagina($url, $conexao);

	geraCabecalho($autor);

  	// Expressao regular para artigos: 
  	// /<a href="(\w|:|\/|\.|,|-)+" class="link-title" >/g

	// Expressão regular para localizar links de artigos de colunas do Estadao
  	//if (preg_match_all("/<a href=\"(\w|:|\/|\.|,|-)+\" class=\"link-title\" >/", $homepage, $matches)) {
	if (preg_match_all("<a href=\"(https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=,]*))\" class=\"link-title\">", $homepage, $matches)) {
		//echo "A match was found.";
	} else {
	    //echo "A match was not found.";
	}

	//echo "\n";

	var_dump($matches);

	// Obtem a quantidade de links retornados
	$quant_links = count($matches[0]);
	$cont = 0;
	$pos_rel = 0;
	while ($cont < $quant_links) {
		// Retorna o link do artigo e a posicao seguinte, para continuar a busca
		list ($link, $pos_rel) = extraiTrecho($matches[0][$cont], "<a href=\"", "\"", $pos_rel);
		echo $link . "\n";
		// Retorna a pagina do link recuperado
		$artigo = obtemPagina($link, $conexao);
		//echo $artigo . "\n";
		// Extrai o trecho da pagina que contem o artigo
		list ($textotags, $pos_rel_artigo) = extraiTrecho($artigo, "<div class=\"n--noticia__content content\">", "<div class=\"n--noticia__fixit\">");
		//echo $textotags . "\n";
		//$trechotexto = encontraFechaTag("<div", "</div", $textotags);
		$fimtag = strpos($textotags, "</div>");
		$trechotexto = substr($textotags, 0, $fimtag);
		//echo $trechotexto . "\n";
		$titulo = ucwords(preg_split("/[,]/", $link)[1]);
		//echo $titulo . "\n";
		geraItem($titulo, $link, strip_tags(html_entity_decode($trechotexto))); // Remoção de tags e entitdades
		$cont++;
	}
	
	geraRodape();

	encerraConexao($conexao);
?>



