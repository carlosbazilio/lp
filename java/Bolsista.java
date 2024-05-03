
public class Bolsista extends Aluno {
	char tipo_bolsa;

	public Bolsista(int m, String n, float c, char t, String cpf) {
		super(m, n, c, cpf);
		// matr = m; nome = n; cr = c;
		tipo_bolsa = t;
	}

	public Bolsista(int m, String n, float c, char t) {
		this(m, n, c, t, "00000000000");
	}

	public String toString() {
		return super.toString() + 
		       " Tipo Bolsa: " + 
		       this.retornaTipoBolsa(tipo_bolsa);
	}

	private String retornaTipoBolsa(char t) {
		return ((t == 'i' || t == 'e' ) ? "Acadêmica" : "Tecnológica");
	}
}
