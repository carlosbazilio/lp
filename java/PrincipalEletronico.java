
public class PrincipalEletronico {
	public static void main(String[] args) {
		Celular c = new Celular ("9999",  "Samsung", "J7", 10);
		System.out.println(c.toString());

		c.alteraBateria(-5);
		System.out.println(c.toString());
	}
}
