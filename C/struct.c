typedef struct produto {
	int id;
	char descricao[100];
	float preco;
	char categoria[20];
} tproduto;

typedef struct importado {
	tproduto produto;
	char pais_origem[20];
} timportado;

void reajustaPrecos(tproduto produto, float percentual) {
	if ((percentual > 1) && (percentual <= 2))
		produto.preco *= percentual;
}

// DEFINIÇÃO
////////////////////////////////////////////////////////////
// USO

tproduto produtos[1000];

int main(int argc, char const *argv[]) {
	//
	produtos[0] = {1, "Polvilho", 1.0, "Guloseimas"};
	reajustaPrecos(produtos[0], 1.1);
	// ..
	reajustaPrecos(produtos[0], -1.1);
	// ..
	// produtos[0].preco = -2; ERRO !!!
	return 0;
}

