import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

interface Remuneravel {
	double getSalario();
}

class Aluno {
	String nome;
	int matr;

	public Aluno (String n, int m) {
		nome = n; matr = m;
	}
}

class Bolsista extends Aluno implements Remuneravel {
	String tipo;
	private double valor;
	Professor orientador;

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

	public Bolsista (String n,
		             int m,
		             String t,
		             double v,
		             Professor o) {
		super(n, m);
		tipo = t; orientador = o;
		// if (valor > o.salario)
		// 	valor = o.salario / 2;
		this.setValor(v);
	}


	public Bolsista (String n,
		             int m,
		             String t,
		             double v,
		             String n_orient,
		             double s_orient) {
		//super(n, m);
		//tipo = t; valor = v;
		//orientador = new Professor(n_orient, s_orient);
		this(n, m, t, v, new Professor(n_orient, s_orient));
	}
}

class Professor implements Remuneravel {
	String nome;
	double salario;

	public Professor (String n, double s) {
		this.nome = n; this.salario = s;
	}

	public double getSalario() {
		return this.salario;
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
		silas = new Aluno("Silas", 1);
		// silas.nome = "Silas";
		// silas.matr = 1;

		Professor quinet;
		quinet = new Professor("Quinet", 7000);

		Professor bazilio;
		bazilio = new Professor("Bazilio", 700);

		Bolsista thalessa;
		thalessa = new Bolsista("Thalessa",
			                    2,
			                    "Monitoria",
			                    15000,
			                    quinet);
		// thalessa.nome = "Thalessa";
		// thalessa.matr = 2;
		// thalessa.tipo = "Monitoria";
		// thalessa.valor = 5000;
		// thalessa.orientador = "Quinet";

		//thalessa.valor = 25000;
		thalessa.setValor(25000);

		Bolsista marcela;
		marcela = new Bolsista("Marcela",
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

		System.out.println("A soma dos salarios é: " + soma);
	}	
}

