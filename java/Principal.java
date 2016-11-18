// Classe
class Livro
{
	// Atributos da classe
	String titulo;
	String autor;
	String editora;
	int num_paginas;

	//Construtor (método especial cuja função é criar objetos)
	public Livro (String t, String a, String e, int n) {
		titulo = t; autor = a; editora = e; num_paginas = n;
	}
}

class Acervo 
{
	Livro livros[];
	int num_livros;

	public Acervo (int tam) {
		livros = new Livro[tam];
		num_livros = 0;
	}

	// Métodos
	public void adicionaLivro(Livro l) {
		livros[num_livros] = l;
		num_livros++;
	}

	public void imprimeAcervo() {
		for (int i=0; i<num_livros; i++) {
			// System.out.println(livros[i].titulo + "," + livros[i].autor + "," + livros[i].editora + "," + livros[i].num_paginas);
			System.out.println(livros[i]);
		}
	}

	public int contaPaginas() {
		int paginas = 0;
		for (int i=0; i<num_livros; i++) {
			paginas += livros[i].num_paginas;
		}
		return paginas;
	}
}


public class Principal {	
	public static void main(String[] args) {
		// Objeto ou instância
		// Livro ctotal = new Livro();
		// ctotal.titulo = "C Total e Completo";
		// ctotal.autor = "Eber Schimidt";
		// ctotal.editora = "LTC";
		// ctotal.num_paginas = 800;

		// Criação dos objetos com uso do construtor
		Livro ctotal = new Livro("C Total e Completo", "Eber Schimidt", "LTC", 800);
		Livro enigmado8 = new Livro("Enigma do 8", "Katherine Neville", "Rocco", 678);
		// System.out.println(ctotal.titulo + "," + ctotal.autor + "," + ctotal.editora + "," + ctotal.num_paginas);
		// System.out.println(enigmado8.titulo + "," + enigmado8.autor + "," + enigmado8.editora + "," + enigmado8.num_paginas);

		// Manipulação direta do objeto acervo
		// Livro acervo[] = new Livro[1000];
		// acervo[0] = ctotal;
		// acervo[1] = enigmado8;
		// int num_livros = 2;
		// int paginas = 0;

		// Cálculo direto da quantidade de páginas do acervo
		// for (int i=0; i<num_livros; i++) {
			// System.out.println(acervo[i].titulo + "," + acervo[i].autor + "," + acervo[i].editora + "," + acervo[i].num_paginas);
			// paginas += acervo[i].num_paginas;
		// }
		// System.out.println("Quantidade de paginas: " + paginas);

		// Programando Acervo como uma classe
		Acervo meuslivros;
		meuslivros = new Acervo(1000);
		meuslivros.adicionaLivro(ctotal);
		meuslivros.adicionaLivro(enigmado8);
		meuslivros.imprimeAcervo();
		System.out.println("Quantidade de paginas: " + meuslivros.contaPaginas());
	}	
}

