class Fila {
	int valores[100];
	int inicio, fim;

	public Fila() {
		this.inicio = 0;
		this.fim = 0;
	}

	public void enqueue (int x) {
		this.valores[this.fim] = x;
		this.fim++;
	}

	public int dequeue() {
		int aux = this.inicio;
		this.inicio++;
		return aux;
	}
}

class 