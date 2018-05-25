
public class Lampada implements Iluminavel /*extends Object*/ { // Herança
	// Atributos
	// acesa e funcionando estão encapsulados
	private boolean acesa;
	String tipo;
	int potencia;
	private boolean funcionando;

	// API
	public void acender () {
		if (this.funcionando)
			this.acesa = true;
	}

	public void apagar () {
		this.acesa = false;
	}

	public void queimar () {
		this.funcionando = false;
		this.apagar();
	}

	public void consertar () {
		this.funcionando = true;
	}

	// Construtor (auxilia na construção de objetos)
	public Lampada (boolean estado, String tipo, int potencia, boolean funcionando) {
		this.acesa = estado;
		this.tipo = tipo;
		this.potencia = potencia;
		this.funcionando = funcionando;
	}

	// Redefinição do método toString da classe Object
	public String toString() {
		return "A lâmpada está " +
			(this.acesa ? "acesa" : "apagada") +
			" é do tipo " + this.tipo +
			" e possui potência de " + this.potencia + "watts" +
			" e" + (!this.funcionando ? " não" : "") + " está funcionando";
	}
}



