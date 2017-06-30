import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

interface Remuneravel {
	double getSalario();
}

abstract class Pessoa {
	String nome;
	String cpf;

	public Pessoa (String n, String c) {
		this.nome = n; this.cpf = c;
	}

	public boolean validaCPF() {
		// Implementação de validação de CPF
		return true;
	}

	abstract public boolean validaMatricula();
}

class Aluno extends Pessoa {
	//String nome;
	int matr;

	public Aluno (String n, String c, int m) {
		super(n, c);
		this.matr = m;
	}

	public boolean validaMatricula() {
		return this.matr <= 1000;
	}

	public boolean podeIrAoCinema() {
		return false;
	}

	// Sobrescrita da classe Object
	// https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#toString()
	public String toString() {
		return "Aluno: " + nome + " Matr: " + matr;
	}
}

class Bolsista extends Aluno implements Remuneravel {
	String tipo;
	private double valor;
	Professor orientador;

	// public String toString() {
	// 	return "Bolsista: " + nome + " Matr: " + matr +
	// 	" Valor bolsa: " + valor;
	// }

	public String toString() {
		return "Bolsista: " + super.toString() +
		" Valor bolsa: " + valor;
	}

	public double getValor() {
		return this.valor;
	}

 	public double getSalario() {
 		return this.getValor();
 	}

	public void setValor(double v) {
		if (v < orientador.salario)
			this.valor = v;
		else
			this.valor = orientador.salario / 2;
	}

	// Sobrescrita do método de Aluno
	public boolean podeIrAoCinema() {
		return true;
	}

	public void setOrientador (Professor p) {
		this.orientador = p;
	}

	public Bolsista (String n,
					 String c,
		             int m,
		             String t,
		             double v,
		             Professor o) {
		super(n, c, m);
		tipo = t; orientador = o;
		// if (valor > o.salario)
		// 	valor = o.salario / 2;
		this.setValor(v);
		// Implementação da navegação de Professor para Bolsista
		this.orientador.bolsistas.add(this);
	}


	public Bolsista (String n,
					 String c,
		             int m,
		             String t,
		             double v,
		             String n_orient,
		             String cpf_orient,
		             int matric_orient,
		             double s_orient) {
		//super(n, m);
		//tipo = t; valor = v;
		//orientador = new Professor(n_orient, s_orient);
		this(n, c, m, t, v, new Professor(n_orient, cpf_orient, matric_orient, s_orient));
	}
}

class Professor extends Pessoa implements Remuneravel {
	//String nome;
	int matr;
	double salario;
	// Lista criada caso desejássemos que a navegação
	//fosse também de professor para bolsista
	List <Bolsista> bolsistas;

	public Professor (String n, String c, int m, double s) {
		super(n, c);
		this.matr = m;
		this.salario = s;
		this.bolsistas = new ArrayList();
	}

	public double getSalario() {
		return this.salario;
	}

	public boolean validaMatricula() {
		return this.matr > 1000;
	}
}


// class Conta {
// 	int numConta;
// 	double saldo;

// 	public void transfere (Conta destino, double s) {
// 		this.saldo -= s;
// 		destino.saldo += s;
// 	}
// }

// /// Main
// 	Conta c1 = new Conta(1, 1000);
// 	Conta c2 = new Conta(2, 200);
// 	c1.transfere(c2, 300);
// ///


public class Alo {	
	public static void main(String[] args) {
		Aluno silas;
		silas = new Aluno("Silas", "0001", 1);
		// silas.nome = "Silas";
		// silas.matr = 1;

		Professor quinet;
		quinet = new Professor("Quinet", "0002", 1001, 7000);

		Professor bazilio;
		bazilio = new Professor("Bazilio", "0003", 1002, 700);

		Bolsista thalessa;
		thalessa = new Bolsista("Thalessa",
								"0004",
			                    2,
			                    "Monitoria",
			                    15000,
			                    quinet);
		// thalessa.nome = "Thalessa";
		// thalessa.matr = 2;
		// thalessa.tipo = "Monitoria";
		// thalessa.valor = 5000;
		// thalessa.orientador = "Quinet";

		//thalessa.orientador = bazilio;
		thalessa.setOrientador(bazilio);

		//thalessa.valor = 25000;
		thalessa.setValor(25000);

		Bolsista marcela;
		marcela = new Bolsista("Marcela",
							   "0005",
							   3,
							   "Extensão",
							   500,
							   bazilio);

		//objeto.MetododoObjeto(Argumentos);

		System.out.println("Alunos: ");
		System.out.println(silas.nome); 
		System.out.println(thalessa.nome);
		System.out.println(thalessa.getValor());
		System.out.println(thalessa.orientador.nome);

		System.out.println(silas); 
		System.out.println(thalessa);
		
		List<Remuneravel> remunerados;
		// remunerados = new ArrayList();
		remunerados = new LinkedList();
		remunerados.add(quinet);
		remunerados.add(bazilio);
		remunerados.add(thalessa);
		remunerados.add(marcela);

		double soma = 0;
		for (Remuneravel r : remunerados)
			// if (r.tipo == Professor)
			// 	soma += r.salario; 
			// else
			// 	soma += r.valor;
			soma += r.getSalario();  // Método Polimórfico

		// Soma usando Streams do Java 8
		double soma2 = remunerados.stream().mapToDouble(x -> x.getSalario()).sum();

		System.out.println("A soma dos salarios é: " + soma);
	}	
}

