
import java.util.*;

public class Luminaria implements Iluminavel /*extends Object*/ {
	List<Lampada> lampadas;

	public boolean estaoAcesas() {
		for (Lampada l : lampadas)
			if (! l.getAcesa())
				return false;
		return true;
	}

	public int getPotenciaInstantanea () {
		int consumo = 0;
		for (Lampada l : lampadas)
			consumo = consumo + l.getPotenciaInstantanea();
		return consumo;
	}

	public void acender () {
		for (Lampada l : lampadas)
			l.acender();
	}

	public void apagar () {
		for (Lampada l : lampadas)
			l.apagar();
	}

	public String toString() {
		String saida = "Esta luminária possui " +
		lampadas.size() + " lâmpadas, e seus estados são: \n";

		for (Lampada l : lampadas)
			saida = saida + l.toString() + "\n";

		return saida;
	}

	public void adicionaLampada (Lampada l) {
		lampadas.add(l);
	}

	public Luminaria () {
		lampadas = new ArrayList<Lampada>();
	}
}