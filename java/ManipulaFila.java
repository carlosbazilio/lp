import java.util.ArrayList;
import java.util.List;

interface IFila {
	void enqueue (Integer x);
	int dequeue();
	boolean empty();
}

interface IExibivel {
	void show();
}

abstract class FilaExibivel implements IFila, IExibivel {

}

class Fila extends FilaExibivel {
	private int valores[];
	private int inicio, fim;

	public Fila() {
		valores = new int[100];
		this.inicio = 0;
		this.fim = 0;
	}

	public void enqueue (Integer x) {
		this.valores[this.fim] = x;
		this.fim++;
	}

	public int dequeue() {
		if (! this.empty()) {
			int aux = this.inicio;
			this.inicio++;
			return aux;
		}
		return -1;
	}

	public boolean empty() {
		return this.inicio == this.fim;
	}

	public int getInicio() {
		return this.inicio;
	}

	public int getFim() {
		return this.fim;
	}

	public void show() {
		for (int i=this.getInicio(); i<this.getFim(); i++)
			System.out.println(this.valores[i]);
	}
}

class NovaFila extends FilaExibivel {
	List<Integer> valores;

	public NovaFila() {
		valores = new ArrayList<Integer>();
	}

	public void enqueue (Integer x) {
		valores.add(x);
	}

	public int dequeue() {
		if (! this.empty())
			valores.remove(0);
		return -1;
	}

	public boolean empty() {
		return valores.isEmpty();
	}

	public void show() {
		for (int i=0; i<valores.size(); i++)
			System.out.println(valores.get(i));
	}
}

//////////////
// DEFINIÇÃO
//////////////
//////////////
// USO
//////////////

public class ManipulaFila {
	public static void main(String[] args) {
		FilaExibivel f;
		f = new NovaFila();
		f.enqueue(10);
		f.enqueue(20);
		f.enqueue(30);
		f.enqueue(40);
		f.dequeue();

		f.show();
	}
}






