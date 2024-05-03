#include "iostream"
#include "cstring"

using namespace std;

class Figura
{
	protected:
		static int qtdTotalFiguras;

	public:
		Figura() {
		}
		static int obtemQtdTotalFiguras() {
			return qtdTotalFiguras;
		}
		virtual double area() = 0;
		string imprime() {
			return "Figura com tamanho: " + to_string(area());
		}
};

int Figura::qtdTotalFiguras = 0;

class Circulo : public Figura 
{
	private:
		double raio;
	public:
		Circulo(double r) {
			raio = r;
			qtdTotalFiguras++;
		}
		double area() {
			return raio * raio * 3.14;
		}
};

class Quadrilatero : public Figura
{
	private:
		double base, altura;
	public:
		Quadrilatero(double b, double a) {
			base = b; altura = a;
			qtdTotalFiguras++;
		}
		double area() {
			return base * altura;
		}
};

class FiguraComposta : public Figura {
	private:
		Figura *figuras[10];
		int qtdFiguras;
	public:
		FiguraComposta() {
			qtdFiguras = 0;
			qtdTotalFiguras++;
		}
		void adicionaFigura(Figura *f) {
			figuras[qtdFiguras] = f;
			qtdFiguras++;
		}
		double area() {
			double soma = 0;
			for (int i = 0; i < qtdFiguras; ++i) {
				soma = soma + figuras[i]->area();
			}
			return soma;
		}
};

class Jogo {
	private:
		Figura *figuras[1000];
		int qtdFiguras;
	public:
		Jogo() {
			qtdFiguras = 0;
		}
		void adicionaFigura(Figura *f) {
			figuras[qtdFiguras] = f;
			qtdFiguras++;
		}
		void desenha() {
			cout << "Áreas dos objetos:" << endl;
			for (int i = 0; i < qtdFiguras; ++i) {
				cout << figuras[i]->area() << endl;
			}
		}
};

int main(int argc, char const *argv[])
{
	Figura *c; 
	c = new Circulo(10);
	Figura *q;
	if (argc <= 1 || !strcmp(argv[1], "quad"))
		q = (new Quadrilatero(3,5));
	else
		q = (new Circulo(5));

	cout << "Qtd total: " << Figura::obtemQtdTotalFiguras() << endl;

	Figura *figuras[2];
	figuras[0] = c; figuras[1] = q;

	for (int i = 0; i < 2; ++i)
	{
		cout << figuras[i]->imprime() << endl;
	}

	FiguraComposta *fc = new FiguraComposta();
	fc->adicionaFigura(q);
	fc->adicionaFigura(c);
	cout << fc->imprime() << endl;

	Jogo *novojogo = new Jogo();
	novojogo->adicionaFigura(c);
	novojogo->adicionaFigura(q);
	novojogo->adicionaFigura(fc);
	novojogo->adicionaFigura(c);
	novojogo->adicionaFigura(q);
	novojogo->adicionaFigura(fc);
	novojogo->desenha();

	cout << "Qtd total: " << Figura::obtemQtdTotalFiguras() << endl;

	return 0;
}










