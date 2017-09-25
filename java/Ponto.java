public class Ponto {
	int x = 4, y = 4;

	public Ponto (int x, int y) {
		if (this.verificaPonto(x, y)) {
			this.x = x; this.y = y;
		}
		else
			System.out.println("Argumentos inválidos!");
	}

	public boolean verificaPonto (int x, int y) {
		return (this.x >= 0 && this.y >= 0);
	}

	public static void main (String [] args) {
		Ponto p = new Ponto (1, 2);
		Ponto p2 = new Ponto (-1, 2);
		String p1x = String.valueOf(p.x);
		System.out.println("Ponto 1: " + p.x + " " + p.y);
		System.out.println("Ponto 2: " + p2.x + " " + p2.y);
	}
}
