
import java.util.*;

public class Luminaria implements Iluminavel /*extends Object*/ {
	List<Lampada> lampadas;

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
		lampadas.size() + " lâmpadas, e seus estados são: ";

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