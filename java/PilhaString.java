public class PilhaString extends Pilha {
	String valores;

	public PilhaString () {
		this.valores = "";
	}

	public void empilhar (int x) {
		if (this.tamanho() < Pilha.getLimite())
			this.valores = this.valores + x + "/";
	}

	public boolean vazia() {
		return this.valores.length() == 0;
	}

	public int desempilhar () {
		if (this.vazia()) {
			return -1;
		}
		int retorno = this.topo();
		this.valores = this.valores.subSequence(0, (this.tamanho() * 2)-2).toString();
		return retorno;
	}

	public int topo() {
		if (this.vazia()) {
			return -1;
		}
		return Integer.valueOf(this.elementos()[this.tamanho() - 1]);
	}

	private int tamanho() {
		return this.elementos().length;
	}

	private String[] elementos() {
		return this.valores.split("/");
	}

	@Override
	public String toString() {
		return this.valores.replace('/', ' ');
	}
}
