class Aluno {
	String nome;
	int matr;

	public Aluno (String n, int m) {
		nome = n; matr = m;
	}
}

class Bolsista extends Aluno {
	String tipo;
	private double valor;
	Professor orientador;

	public double getValor() {
		return valor;
	}

	public void setValor(double v) {
		if (v < orientador.salario)
			valor = v;
		else
			valor = orientador.salario / 2;
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
		setValor(v);
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

class Professor {
	String nome;
	double salario;

	public Professor (String n, double s) {
		nome = n; salario = s;
	}
}

public class Alo {	
	public static void main(String[] args) {
		Aluno silas;
		silas = new Aluno("Silas", 1);
		// silas.nome = "Silas";
		// silas.matr = 1;

		Professor quinet;
		quinet = new Professor("Quinet", 7000);

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

		System.out.println("Alunos: ");
		System.out.println(silas.nome); 
		System.out.println(thalessa.nome);
		System.out.println(thalessa.getValor());
		System.out.println(thalessa.orientador.nome);
	}	
}

