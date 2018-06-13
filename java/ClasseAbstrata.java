import java.util.*;

abstract class Aluno {
	String nome;
	int matr;
	double cr;

	public Aluno(String n, int m, double c) {
		this.nome = n; this.matr = m; this.cr = c;
	}

	public abstract int getCodCurso();

	public String toString() {
		return "Nome: " + this.nome + 
		       "\nMatr: " + this.matr +
		       "\nCR: " + this.cr +
		       "\nCurso: " + this.getCodCurso();
	}
}

class CC extends Aluno {
	public CC(String n, int m, double c) {
		super(n, m, c);
	}

	public int getCodCurso() {
		return 60;
	}
}

class EP extends Aluno {
	public EP(String n, int m, double c) {
		super(n, m, c);
	}

	public int getCodCurso() {
		return 63;
	}
}

public class ClasseAbstrata {	
	public static void main(String[] args) {
		Aluno a1 = new CC("Matheus", 1, 9);
		Aluno a2 = new CC("Isabela", 2, 9);
		Aluno a3 = new EP("Filipe", 3, 9);
		List<Aluno> alunos = new ArrayList();
		alunos.add(a1); 
		alunos.add(a2); 
		alunos.add(a3);
		alunos.forEach(System.out::println);
	}
}


