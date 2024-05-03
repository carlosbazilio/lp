class Limite {
	private int valor;
	private boolean aberto;

	public Limite(int valor, boolean aberto) {
		this.valor = valor;
		this.aberto = aberto;
	}

	public Limite normatiza(boolean inferior) {
		if (aberto)
			if (inferior)
				return new Limite(valor+1, !aberto);
			else
				return new Limite(valor-1, !aberto);
		else
			return this;
	}

	public int getValor() {
		return this.valor;
	}
}

class Intervalo {
	private Limite inf, sup;

	public Intervalo(Limite inf, Limite sup) {
		this.inf = inf;
		this.sup = sup;
	}

	public Intervalo normatiza() {
		return new Intervalo(inf.normatiza(true), sup.normatiza(false));
	}

	public boolean contem (int v) {
		Intervalo normatizado = this.normatiza();
		return normatizado.inf.getValor() <= v && 
		       normatizado.sup.getValor() >= v;
	}

	public boolean intercepta (Intervalo i) {
		Intervalo thisnorm = this.normatiza();
		Intervalo inorm = i.normatiza();
		return thisnorm.contem(inorm.inf.getValor()) ||
		       thisnorm.contem(inorm.sup.getValor());
	}
}

public class Intervalos {
	public static void main(String[] args) {
		Limite l1 = new Limite(5, false);
		Limite l2 = new Limite(8, false);
		Limite l3 = new Limite(3, true);
		Limite l4 = new Limite(6, false);

		Intervalo i1 = new Intervalo(l1, l2);
		Intervalo i2 = new Intervalo(l3, l4);

		System.out.println(i2.intercepta(i1));
	}
}

