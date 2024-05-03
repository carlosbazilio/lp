
public class Pilhas {
	public static void main(String[] args) {
		IPilha numeros [];
		numeros = new IPilha[3];
		numeros[0] = new PilhaString();
		numeros[1] = new PilhaVet();
		numeros[2] = new PilhaLista();
		numeros[0].empilhar(1);
		numeros[1].empilhar(3);
		numeros[1].empilhar(7);
		numeros[2].empilhar(1);
		numeros[2].empilhar(4);
		numeros[2].empilhar(5);
		System.out.println(numeros[0]);
		System.out.println(numeros[1]);
		System.out.println(numeros[2]);
		System.out.println(numeros[0].iguais(numeros[2]));
		System.out.println(Pilha.getLimite());
	}
}
