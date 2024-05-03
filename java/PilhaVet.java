public class PilhaVet extends Pilha {
	int valores[];
	private int qtd;

	public PilhaVet () {
		this.valores = new int[Pilha.getLimite()];
		this.qtd = 0;
	}

	public void empilhar (int x) {
		if (this.qtd < valores.length) {
			this.valores[this.qtd] = x;
			this.qtd++;
		}
	}

	public int desempilhar () {
		if (this.vazia()) {
			return -1;
		}
		this.qtd--;
		return this.valores[this.qtd];
	}

	public boolean vazia() {
		return qtd == 0;
	}

	public int topo() {
		if (vazia()) {
			return -1;
		}
		return valores[qtd-1];
	}

	@Override
	public String toString() {
		String retorno = "";
		for (int i=qtd-1; i>=0; i--) {
			retorno = retorno + valores[i] + " ";
		}
		return retorno;
	}
}
