class Equipe {
	final String nome;
	final String nacionalidade;

	public Equipe (String n, String nac) {
		this.nome = n; this.nacionalidade = nac;
	}

	// Não permitido
	// public void setNome (String n) {
	// 	this.nome = n;
	// }
}

class TimeFutebol extends Equipe {
	String mascote;

	public TimeFutebol (String n, String nac, String mascote) {
		super(n, nac);
		this.mascote = mascote;
	}
}

public class TesteFinal {	
	public static void main(String[] args) {
		Equipe fla = new Equipe("Flamengo", "Bra");
		//fla.nome = "Mengão";
		//fla.setNome("Mengão");

		TimeFutebol fla2 = new TimeFutebol("Flamengo", "Bra", "urubu");
		fla2.nome = "Mengão";
	}	
}


