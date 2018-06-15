using System;

class Aluno {
  public string Nome { get; set; }

  public int Matr { get; set; }

  public Aluno (string s, int m) {
    Nome = s;
    Matr = m;
  }

  public virtual int getCodCurso() { return 0; }
}

class CC : Aluno {

  public CC(string s, int m) : base(s, m) {}

  public override int getCodCurso() { return 60; }
}

class MainClass {
  public static void Main (string[] args) {
    Aluno a = new CC("Fulano", 1);
    Console.WriteLine (a.Nome + " " + a.getCodCurso());
  }
}

