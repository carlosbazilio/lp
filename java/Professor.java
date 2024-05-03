public class Professor extends Pessoa {
	String departamento;

	public Professor(String n, String c, String d) {
		super(n, c);
		this.departamento = d;
	}

	public void exibe() {
		System.out.println(this);
	}

	public String toString() {
		return "Nome: " + this.nome + " Depto: " + this.departamento;
	}
}


