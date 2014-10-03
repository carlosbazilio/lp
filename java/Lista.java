package br.uff.puro.comp.lp.exemplos;

class MinhaLista<T> {
	T objeto;
	MinhaLista<T> proximo;
	
	public MinhaLista(T obj) {
		objeto = obj;
		proximo = null;
	}
	
	public MinhaLista<T> add (T obj) {
		MinhaLista<T> aux = new MinhaLista<T>(obj);
		aux.proximo = this;
		return aux;
	}
	
	public void imprime() {
		MinhaLista<T> aux = this; 
		while (aux != null) {
			System.out.println(aux.objeto + "\n");
			aux = aux.proximo;
		}
	}
}

class Aluno {
	int matr;
	double cr;
	String nome;
	
	public Aluno(int matr, double cr, String nome) {
		super();
		this.matr = matr;
		this.cr = cr;
		this.nome = nome;
	}
	
	public String toString() {
		return matr + " " + cr + " " + nome;
	}
}

public class Lista {
	public static void main(String[] args) {
		MinhaLista<Aluno> ml = new MinhaLista<Aluno>(new Aluno(1, 10, "Kildare"));
		ml = ml.add(new Aluno(2, 10, "Shock"));
		ml.imprime();
	}
}
