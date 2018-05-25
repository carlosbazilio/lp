public class Celular extends Eletronico {
	String numero;

	public Celular (String numero, String f, String m, int c) {
		super(f, m, c);
		this.numero = numero;
	}

	// c.toString()
	// Complementa o método toString de Eletronico
	public String toString() {
		return "Celular com número " + this.numero + "\n " +
			super.toString();
	}
}
