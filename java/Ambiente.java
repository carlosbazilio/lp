
import java.util.*;


public class Ambiente /* extends Object */ {
	private List<Iluminavel> iluminacao;

	public Ambiente () {
		iluminacao = new ArrayList<Iluminavel>();
	}

	public void adicionaIluminacao (Iluminavel i) {
		iluminacao.add(i);
	}

	public void acender () {
		for (Iluminavel i : iluminacao) {
			i.acender();
		}
	}

	public String toString () {
		String saida = "";
		for (Iluminavel i : iluminacao) {
			saida = saida + i.toString();
		}
		return saida;
	}
}