class No {
	int valor;
	No prox;

	public No(int x) {
		this.valor = x;
		this.prox = null;
	}

	public String toString() {
		return Integer.toString(valor);
	}
}

public class PilhaLista extends Pilha {
	No valores;

	public PilhaLista () {
		valores = null;
	}

	public void empilhar (int x) {
		No novo = new No(x);
		novo.prox = this.valores;
		this.valores = novo;
	}

	public boolean vazia() {
		return this.valores == null;
	}

	public int topo() {
		if (this.vazia()) {
			return -1;
		}
		return this.valores.valor;
	}

	public int desempilhar () {
		if (this.vazia()) {
			return -1;
		}
		int retorno = this.topo();
		this.valores = this.valores.prox;
		return retorno;
	}

	@Override
	public String toString() {
		No aux = this.valores;
		String retorno = "";
		while (aux != null) {
			retorno = retorno + aux.toString() + " ";
			aux = aux.prox;
		}
		return retorno;
	}
}
