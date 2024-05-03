public abstract class Pessoa implements Exibivel {
	String nome;
	String cpf;

	public Pessoa (String n, String c) {
		this.nome = n;
		this.cpf = c;
	}

	// public abstract void exibe();

	public boolean validaCPF () {
		// Validação a ser feita
		return true;
	}
}


