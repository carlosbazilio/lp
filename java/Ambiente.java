
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

	public void apagar () {
		for (Iluminavel i : iluminacao) {
			i.apagar();
		}
	}

	public String toString () {
		String saida = "";
		for (Iluminavel i : iluminacao) {
			saida = saida + i.toString() + "\n";
		}
		return saida;
	}

	public int calculaConsumoInstantaneo() {
		int consumo = 0;
		for (Iluminavel i : iluminacao) {
			consumo = consumo + i.getPotenciaInstantanea(); // Polimorfismo !!!!
			// if (i.getClass().getSimpleName().compareTo("Lampada") == 0) // Reflexão
			// 	consumo = consumo + i.getPotenciaInstantanea();
			// else
			// 	if (i.getClass().getSimpleName().compareTo("Luminaria") == 0)
			// 		consumo = consumo + i.getPotenciaInstantanea();
				// else
				// 	if (i.getClass().getSimpleName().compareTo("Abajour") == 0)
				// 		consumo = consumo + ((Luminaria) i).potencia;
		}
		return consumo;
	}
}




