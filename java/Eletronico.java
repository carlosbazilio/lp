public class Eletronico /* extends Object */ {
	String fabricante;
	String modelo;
	private int capacidadeBateria;

	public Eletronico (String f, String m, int c) {
		this.fabricante = f; this.modelo = m; this.capacidadeBateria = c;
	}

	public void alteraBateria (int valor) {
		if (capacidadeBateria + valor >= 0)
			this.capacidadeBateria += valor;
	}

	// Redefiniu o método toString de Object
	public String toString() {
		return "Eletronico fabricado por " + this.fabricante +
		" modelo " + this.modelo + " com bateria " + this.capacidadeBateria;
	}
}

