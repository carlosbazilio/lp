pertence _ [] = False
pertence el (cab:resto) | el == cab = True
						| otherwise = pertence el resto
			
alunos = [("joao", "joao@email.br", ["lp", "ed", "apa"]), ("jose", "jose@email.br", ["calc2", "prog2"]), ("maria", "maria@email.br", ["ed", "apa"])]

mails turma = (mails_aux turma alunos)
mails_aux turma [] = []
mails_aux turma ((_, mail, turmas):resto)
	| pertence turma turmas = mail:(mails_aux turma resto)
	| otherwise = (mails_aux turma resto)

disciplinas = [("ed", 4), ("lp", 4), ("apa", 4), ("calc2", 4), ("prog2", 6)]

creditos aluno = creditos_aux aluno alunos disciplinas

creditos_aux aluno [] _ = 0
creditos_aux aluno ((nome, mail, turmas):resto) discs
	| aluno == nome = (calcula turmas discs)
	| otherwise = (creditos_aux aluno resto discs)

calcula [] _ = 0
calcula _ [] = 0
calcula (t1:resto) discs = 
	(calcula_aux t1 discs) + (calcula resto discs)
	
calcula_aux turma [] = 0
calcula_aux turma ((t, c):resto)
	| turma == t = c
	| otherwise = (calcula_aux turma resto)
	
	