function fat(x) {
	function fat_aux(x1, acum) {
		// if (x1 === 0)
		if (x1 === 0) // Sugestão do https://repl.it para ===
			return acum;
		else
			return fat_aux(x1 - 1, acum*x1);
	}
	return fat_aux(x, 1);
}

