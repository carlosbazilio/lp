import java.util.*;

interface ILivro {
	String imprimir();
	int obtemNumeroPaginas();
}

// Classe
// Classes em Java extendem implicitamente a classe Object
//class Livro //extends Object
class Livro implements ILivro
{
	// Atributos da classe
	String titulo;
	String autor;
	Editora editora;
	int num_paginas;

	//Construtor (método especial cuja função é criar objetos)
	public Livro (String titulo, String a, Editora e, int n) {
		this.titulo = titulo; this.autor = a; this.editora = e; this.num_paginas = n;
		e.adicionaLivro(this);
	}

	// Redefinição do método toString() herdado da classe Object
	public String imprimir() {
		return this.titulo + "," + 
			   this.autor + "," + 
			   this.editora.toString() + "," + 
			   this.num_paginas;
	}

	public int obtemNumeroPaginas() {
		return this.num_paginas;
	}
}

class Editora {
	String nome;
	String endereco;
	String contato;
	String cnpj;
	//Livro livros[];
	// Substituição do tipo vetor por uma lista (coleção genérica de Java)
	List <Livro>livros;

	public Editora (String n, String e, String c, String cn) {
		nome = n; endereco = e; contato = c; cnpj = cn;
		//livros = new Livro[1000];
		livros = new ArrayList<Livro>();
	}

	public String toString() {
		return nome + " " + endereco + " " + contato + " " + cnpj;
	}

	public void adicionaLivro(Livro l) {
		livros.add(l);
	}
}

class Dicionario extends Livro {
	String origem;
	String destino;

	public Dicionario (String t, String a, Editora e, int n,
		               String o, String d) {
		super(t, a, e, n);
		origem = o;
		destino = d;
	}
	public String toString() {
		// Redefinição do método com chamada do método na superclasse
		return super.toString() +
			   " " + origem + "->" + destino;
	}
}

class Acervo
{
	// Encapsulamento
	private ILivro livros[];
	private int num_livros;

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
			/*System.out.println(livros[i].titulo + "," + 
				               livros[i].autor + "," + 
				               livros[i].editora + "," + 
				               livros[i].num_paginas);*/
			// Chamada do método toString() da classe Livro
			// Chamada Polimórfica: ora chama o método
			//de Livro, ora de Dicionário
			System.out.println(livros[i].imprimir());
		}
	}

	public int contaPaginas() {
		int paginas = 0;
		for (int i=0; i<num_livros; i++) {
			paginas += livros[i].obtemNumeroPaginas();
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

		Editora ltc = new Editora("LTC", "Rio de Janeiro", "ltc@ltc", "0001");
		Editora rocco = new Editora("Rocco", "Sao Paulo", "rocco@rocco", "0002");
		Editora atlas = new Editora("Atlas", "Tocantins", "atlas@atlas", "0003");

		// Criação dos objetos com uso do construtor
		Livro ctotal = new Livro("C Total e Completo", "Eber Schimidt", ltc, 800);
		Livro enigmado8 = new Livro("Enigma do 8", "Katherine Neville", rocco, 678);
		// System.out.println(ctotal.titulo + "," + ctotal.autor + "," + ctotal.editora + "," + ctotal.num_paginas);
		// System.out.println(enigmado8.titulo + "," + enigmado8.autor + "," + enigmado8.editora + "," + enigmado8.num_paginas);

		//Dicionario aurelio;
		Livro aurelio = new Dicionario("Dicionario da Lingua Portuguesa", "Aurelio", atlas, 425, "Portugues", "Portugues");
		
		// ltc.adicionaLivro(ctotal);
		// rocco.adicionaLivro(enigmado8);
		// atlas.adicionaLivro(aurelio);

		System.out.println("Quantidade de livros LTC: " + ltc.livros.size());

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
		Acervo meuslivros, acervo_especial;
		meuslivros = new Acervo(1000);
		// System.out.println(meuslivros.toString());
		meuslivros.adicionaLivro(ctotal);
		meuslivros.adicionaLivro(enigmado8);
		// Acesso indevido, mas controlado pelo encapsulamento (private)
		// meuslivros.livros[1005] = ctotal;

		meuslivros.adicionaLivro(aurelio);

		meuslivros.imprimeAcervo();
		System.out.println("Quantidade de paginas: " + meuslivros.contaPaginas());
	}	
}

