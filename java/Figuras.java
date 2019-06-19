class Figura {
	int x, y;
	Estilo formato;

	public Figura(int px, int py) {
		x = px; 
		y = py;
		formato = new Estilo("Transparente", "Transparente", false);
	}

	public Figura(int px, int py, Estilo e) {
		x = px; 
		y = py;
		formato = e;
	}

	public void desenha() {
		System.out.println("Valores " + x + ", " + y);
		System.out.println("Cor " + formato.cor);	
	}
}

class Retangulo extends Figura {
	int lado1, lado2;
	public Retangulo(int px, int py, int l1, int l2) {
		super(px, py);
		lado1 = l1;
		lado2 = l2;
	}

	public Retangulo(int px, int py, int l1, int l2, Estilo e) {
		super(px, py, e);
		lado1 = l1;
		lado2 = l2;
	}

	public void desenha() {
		super.desenha();
		//System.out.println("Valores " + x + ", " + y);
		System.out.println("Retangulo com valores " + lado1 + ", " + lado2);
	}
}

class Estilo {
	String cor;
	String cor_borda;
	boolean preenchido;

	public Estilo(String c, String cb, boolean p) {
		cor = c; cor_borda = cb; preenchido = p;
	}
}

/*class Triangulo extends Figura {

}

class Circulo extends Figura {

}*/

public class Figuras {
	public static void main(String[] args) {
		// Figura f = new Figura(10,10);
		// f.desenha();
		Figura r;
		Retangulo g;
		Estilo atencao = new Estilo("Branca", "Vermelha", true);
		r = new Retangulo(10,10,30,40, atencao);
		r.desenha();
	}
}
