/*
class Aluno(Object): // Python
class Aluno : Object: // C++, C#
class Aluno(int matr, String nome, float cr, Curso curso):Object // +/-Kotlin
*/

public class Aluno extends Pessoa {
	int matr;
	private float cr;
	Curso curso;

	public String toString() {
		return "Nome: " + nome + 
		       " Curso: " + curso.nome +
		       " cr: " + cr;
	}

	public Aluno(int m, String n, float c, String cpf) {
		super(n, cpf);
		matr = m;
		this.setCr(c);
	}

	public Aluno(int m, String n, float c) {
		this(m, n, c, "00000000000");
	}

	public Aluno(int m, String n, String cpf) {
		this(m, n, 0, cpf);
		// this.matr = m; this.nome = n; this.cr = 0;
	}

	public void setCr(float c) {
		this.cr = (c < 0) ? -c : c;	
	}

	public boolean compara(Aluno a2) {
		return (this.matr == a2.matr) &&
		       (this.nome == a2.nome) &&
		       (this.curso == a2.curso);
	}

	public void exibe() {
		System.out.println(this);
	}
}
