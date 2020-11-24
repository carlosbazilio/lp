
//public class Lampada implements Iluminavel /*extends Object*/ { // Herança
public class Lampada extends LampadaAbstrata { // Herança
	// Atributos
	// acesa e funcionando estão encapsulados
	String tipo;

	// Construtor (auxilia na construção de objetos)
	public Lampada (boolean estado, String tipo, int potencia, boolean funcionando) {
		// this.acesa = estado;
		// this.potencia = potencia;
		// this.funcionando = funcionando;
		super(estado, potencia, funcionando);
		this.tipo = tipo;
	}

	public double getPreco() {
		return 0;
	}

	// Redefinição do método toString da classe Object
	public String toString() {
		return "A lâmpada está " +
			(this.getAcesa() ? "acesa" : "apagada") +
			" é do tipo " + this.tipo +
			" e possui potência de " + this.potencia + "watts" +
			" e" + (!this.funcionando ? " não" : "") + " está funcionando";
	}
}



