//============================================================================
// Name        : TestesCPP.cpp
// Author      : Bazilio
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>

using namespace std;

class PSolucao {

private:
	int valor;
	
public:
	PSolucao () {
		valor = 0;
	}
	
	PSolucao (const PSolucao& pSol) {
		valor = pSol.valor;
	}
	
	virtual ~PSolucao () {
		cout << "Chamou delete base!" << endl;
	}
	
	int getValor() {
		return valor;
	}
	
	void setValor(int val) {
		valor = val;
	}

};

class PSolucaoNavio : public PSolucao {
	
public:
	PSolucaoNavio () : PSolucao() {
	}

	PSolucaoNavio (const PSolucaoNavio& pSol) : PSolucao (pSol) {
	}
	
	PSolucaoNavio copy(PSolucaoNavio& pSol) {
		PSolucaoNavio copia = PSolucaoNavio(pSol);
		copia.setValor(pSol.getValor() + 1);
		return copia;
	}
	
	~PSolucaoNavio () {
		cout << "Chamou delete!" << endl;
	}
	
	/*PSolucaoNavio operator=( const PSolucaoNavio& pSol ) {
		return PSolucaoNavio(pSol);
	}*/

};


class Repositorio {
};


int main() {
	PSolucaoNavio sol = PSolucaoNavio ();
	PSolucaoNavio sol2 = sol;
	sol2.setValor(3);
	PSolucaoNavio sol3;
	sol3 = sol2;
	sol2.setValor(-1);
	cout << sol.getValor() << endl;
	cout << sol3.getValor() << endl;
	
	PSolucao *sol4 = new PSolucaoNavio ();
	sol4->setValor(15);
	cout << sol4->getValor() << endl;

	void *p = sol4;
	delete (PSolucao *)p;
	cout << "Delete sol4!" << endl;
	
	return 0;
}
