interface IPilha {
	void empilhar (int x);
	int desempilhar ();
	boolean vazia();
	int topo();
	String toString();
	boolean iguais (IPilha p);
}