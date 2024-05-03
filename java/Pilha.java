public abstract class Pilha implements IPilha {
	private static int limite = 50;

	public static int getLimite() {
		return limite;
	}

	public boolean iguais (IPilha p) {
		while (!this.vazia() && !p.vazia()) {
			if (this.desempilhar() != p.desempilhar())
				return false;
		}
	 	if (this.vazia() && p.vazia())
	 		return true;
	 	return false;
	}
}