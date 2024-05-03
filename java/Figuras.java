interface Desenhavel {
	public void desenha();
}

abstract class Figura implements Desenhavel {
	int x, y;
	private Estilo formato;

	public Figura(int px, int py, Estilo e) {
		x = px; 
		y = py;
		formato = e;
	}

	public Figura(int px, int py) {
		this(px, py, new Estilo());
	}

	public abstract void desenha();

	public Estilo getFormato() {
		return this.formato;
	}
}

class Retangulo extends Figura {
	int lado1, lado2;
	public Retangulo(int px, int py, int l1, int l2) {
		this(px, py, l1, l2, new Estilo());
	}

	public Retangulo(int px, int py, int l1, int l2, Estilo e) {
		super(px, py, e);
		lado1 = l1;
		lado2 = l2;
	}

	public void desenha() {
		System.out.println("Retangulo com valores " + lado1 + ", " + lado2 +
						   " com cor " + this.getFormato().getCor());
	}
}

class Estilo {
	private String cor; // Atributos de instancia
	String cor_borda;
	boolean preenchido;
	private static String filtro; // Atributo de classe

	public Estilo() {
		this("Transparente", "Transparente", false);
	}

	public Estilo(String c, String cb, boolean p) {
		this.cor = c;
		this.cor_borda = cb;
		this.preenchido = p;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String novacor) {
		this.cor = novacor;
	}

	public static String getFiltro() {
		return Estilo.filtro;
	}

	public static void setFiltro(String f) {
		filtro = f;
	}
}

class Circulo extends Figura {
	int raio;

	public Circulo(int px, int py, int r) {
		this(px, py, r, new Estilo());
	}

	public Circulo(int px, int py, int r, Estilo e) {
		super(px, py, e);
		raio = r;
	}

	public void desenha() {
		System.out.println("Circulo com raio " + raio +
						   " com cor " + this.getFormato().getCor());
	}
}

class FiguraNova extends Figura {
	public FiguraNova(int px, int py) {
		super(px, py);
	}
	@Override
	public void desenha() {
		System.out.println("Figura nova na posição " + x + " e " + y +
						   " com cor " + this.getFormato().getCor());
	}
	@Override
	public String toString() {
		return "Figura nova na posição " + x + " e " + y;
	}
}

class Imagem implements Desenhavel {
	String caminho;
	public Imagem(String c) {
		caminho = c;
	}

	public void desenha() {
		System.out.println("Desenha imagem com caminho " + caminho);
	}
}

// Definicao
///////////
// Uso

public class Figuras {
	public static void main(String[] args) {
		Desenhavel figuras[];
		figuras = new Desenhavel[1000];

		Estilo destaque = new Estilo("Vermelha", "Preto", true);

		Desenhavel r;
		r = new Retangulo(10, 10, 30, 40, destaque);

		Desenhavel c;
		c = new Circulo(20, 20, 5, destaque);

		figuras[0] = r;
		figuras[1] = c;
		figuras[2] = new FiguraNova(40, 40);

		Desenhavel png = new Imagem("c://usuarios/bazilio/avatar.png");
		figuras[3] = png;

		// png.getFormato().setCor("Azul");

		for (int i=0; i<4; i++) {
			System.out.println("Objeto " + i + ":");
			figuras[i].desenha(); // Polimorfismo
		}
	}
}
