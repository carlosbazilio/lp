// Classe = Struct + Funções
// Objeto = Variável Struct + Funções

import java.util.*;

public class PrincipalLampada {
	public static void main(String[] args) {
		// Lampada l = new Lampada();
		// l.acesa = false;
		// l.tipo = "led";
		// l.potencia = 60;
		Lampada l = new Lampada(false, "led", 60, true);
		//l.acender();
		//l.queimar();
		//System.out.println(l.toString());

		Lampada l2 = new Lampada(false, "led", 80, true);

		Luminaria lumi = new Luminaria();
		lumi.adicionaLampada(l);
		lumi.adicionaLampada(l2);

		//System.out.println(lumi.toString());

		Lampada l3 = new Lampada(false, "fluorescente", 100, true);

		// List <Iluminavel> ambiente = new ArrayList();

		// ambiente.add(l3);
		// ambiente.add(lumi);

		// // Polimorfismo
		// for (Iluminavel i : ambiente) 
		// 	i.acender(); // Método Polimórfico

		// for (Iluminavel i : ambiente)
		// 	System.out.println(i.toString());

		Ambiente ambiente = new Ambiente();

		ambiente.adicionaIluminacao(l3);
		ambiente.adicionaIluminacao(lumi);
		ambiente.acender();
		System.out.println(ambiente);
	}
}










