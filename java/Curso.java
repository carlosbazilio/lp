public class Curso implements Exibivel {
	int cod;
	String nome;
	int ch;
	Aluno alunos[];

	public void exibe() {
		System.out.println("Curso: " + this.nome);
	}
}

