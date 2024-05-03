abstract class Figura {
	private int x, y; // Encapsulamento; Atributos de instância
	private static String idioma; // Atributo de classe

	public Figura(int cx, int cy, String i) {
		setX(cx);
		setY(cy);
		idioma = i;
	}

	public Figura(int cx, int cy) {
		this(cx, cy, "pt-br");
	}

	public abstract void desenha();

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int px) {
		this.x = Math.abs(px);
	}

	public void setY(int py) {
		this.y = Math.abs(py);
	}

	public static String getIdioma() {
		return idioma;
	}

	public static void setIdioma(String i) {
		idioma = i;
	}
}

class Circulo extends Figura {
	double raio;

	Circulo(int cx, int cy, double raio) { // Construtor default
		super(cx, cy); 
		this.raio = raio;
	}

	public void desenha() {
		switch (Circulo.getIdioma()) {
			case "pt-br": 
				System.out.println("Desenhar circulo com raio " + this.raio +
		                   " na posição (" + this.getX() + "," + this.getY() + ")");
				break;
			case "en":
				System.out.println("Draw a circle with radius " + this.raio +
		                   " at the location (" + this.getX() + "," + this.getY() + ")");
				break;
		}
	}
}

class Retangulo extends Figura {
	double lado1, lado2;

	Retangulo(int cx, int cy, double l1, double l2) { // Construtor default
		super(cx, cy); 
		this.lado1 = l1; this.lado2 = l2;
	}

	public void desenha() {
		switch (Retangulo.getIdioma()) {
			case "pt-br": 
				System.out.println("Desenhar retangulo com lados " + this.lado1 + " e " + this.lado2 +
		                   " na posição (" + this.getX() + "," + this.getY() + ")");
				break;
			case "en":
				System.out.println("Draw a rectangle with sides " + this.lado1 + " e " + this.lado2 +
		                   " at the location (" + this.getX() + "," + this.getY() + ")");
				break;
		}
	}
}

//////////////
// DEFINIÇÃO
//////////////
//////////////
// USO
//////////////


public class ObjetosGeometricos {
	public static void main(String[] args) {
		Figura objetos[] = new Figura[100];

		Figura c;
		c = new Circulo(10,-10,5);
		Figura r;
		r = new Retangulo(-10,10,20,30);

		objetos[0] = c;
		objetos[1] = r;

		Figura.setIdioma("en");
	 
		for (Figura objeto : objetos) {
			if (objeto == null)
				break;
			objeto.desenha(); // Polimorfismo
		}
	}
}

////
// objeto.metodo(argumentos);
// classe.metodo(argumentos);













