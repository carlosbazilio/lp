class ContaBancaria {
	int num_conta;
	String nome;
	private double saldo;

	public ContaBancaria(...) {

	}

	public double getSaldo() {
		return this.saldo;
	}

	public void deposito(double x) {
		this.saldo += x;
	}

	public void saque(double x) {
		if (x <= this.saldo)
			this.saldo -= x;
	}

	public void transferencia(double x, ContaBancaria destino) {
		this.saque(x);
		destino.deposito(x);
		System.out.println("Transferencia de " + x + " dinheiros de " +
		                   this.nome + " para " + destino.nome);
	}

	public static void transferencia(double x, ContaBancaria origem, ContaBancaria destino) {
		origem.saque(x);
		destino.deposito(x);
	}
}

/// main()

	ContaBancaria raphael = new ContaBancaria(1000);
	ContaBancaria thayna = new ContaBancaria(10000);

	thayna.transferencia(1000, raphael);

	raphael.transferencia(1000, mariana);

	ContaBancaria.transferencia(1000, thayna, raphael);


