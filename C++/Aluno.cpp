#include "iostream"

using namespace std;

class Aluno
{
	public:
		string nome;
	protected:
		int matr;
	private:
		float cr;

	public:
		Aluno() {

		}

		Aluno(string n, int m, float c) {
			this->nome = n; this->matr = m;
			this->setCr(c);
		}

		~Aluno() {
			// cout << "Destruindo objeto " << getNome() << "\n";
		}

		void setCr (float c) {
			if (c < 0)
				c = -c;
			cr = c;
		}

		float getCr() {
			return cr;
		}

		string getNome() {
			return nome;
		}

		virtual void imprime();		
};

void Aluno::imprime() {
	cout << getNome() << " cr: " << getCr() << "\n";		
}

class Bolsista : public Aluno {
	private:
		char tipo_bolsa;

	public:
		Bolsista(string n, int m, float c, char t):Aluno(n,m,c) {
			tipo_bolsa = t;
		}

		void imprime() {
			cout << "Bolsista: " 
				 << getNome() 
				 << " cr: " 
				 << getCr() 
				 << " Bolsa: "
				 << tipo_bolsa
				 << "\n";	
		}

		char getTipoBolsa() {
			return tipo_bolsa;
		}
};

int main(int argc, char const *argv[])
{
	Aluno a("Fabricio", 1, -5);
	// a.nome = "Fabricio";
	// // a.cr = -5;
	// a.setCr(-5);
	// a.matr = 1;
	Aluno b("Gabriel", 2, -7);

	Aluno *c;
	c = new Aluno("Matheus", 3, 10);

	Aluno *d;
	d = new Bolsista("Victor", 4, 10, 'e');

	Aluno *alunos[2];
	alunos[0] = c;
	alunos[1] = d;

	for (int i = 0; i < 2; ++i)
	{
		alunos[i]->imprime(); // Método Polimórfico
	}

	delete c;
	delete d;

	return 0;
}










