<?php
	function extraiTrecho($string, $trechoInicial, $trechoFinal, $apartir = 0) {
 		$in = stripos($string, $trechoInicial, $apartir) + strlen($trechoInicial);
		$fi = stripos($string, $trechoFinal, $in);
		return array (substr($string, $in, $fi - $in), $fi);
	}

	$ch = curl_init();
	$autor = $_GET["autor"];
	$url = "http://topicos.estadao.com.br/" . $autor;
	
	//curl_setopt($ch, CURLOPT_URL, "http://topicos.estadao.com.br/luis-fernando-verissimo");
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_HEADER, 0);
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
	//$timeout = 5;
	//curl_setopt ($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
	$homepage = curl_exec($ch);
	curl_close($ch);

	echo "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
	echo "<rss version=\"2.0\">";

	echo "<channel>";
  	echo "<title>" . ucwords($autor) . " - Estadao</title>";
  	echo "<link>http://topicos.estadao.com.br/" . $autor . "</link>";
  	echo "<description>Coluna do " . ucwords($autor) . " - Estadao</description>";

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
	}

	echo "</channel></rss>";
?>



