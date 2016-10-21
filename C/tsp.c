#include "stdio.h"
#define MAXINT 32767
#define N_CIDADES 8

typedef struct tSolucao {
    int custo;
    int cidades[N_CIDADES];
} tSolucao;

enum cidades {Rio, Brasilia, Belem, Manaus, BoaVista, Teresina, Fortaleza, Natal};
/*int custo[N_CIDADES][N_CIDADES] = {{MAXINT, 300, 727, 504, 904, 527, 420, 440},
								   {-1, MAXINT, 331, 379, 453, 377, 407, 400},
								   {-1, -1, MAXINT, 221, 371, 460, 252, 361},
								   {-1, -1, -1, MAXINT, 354, 680, 430, 600},
								   {-1, -1, -1, -1, MAXINT, 664, 798, MAXINT},
								   {-1, -1, -1, -1, -1, MAXINT, 92, 515},
								   {-1, -1, -1, -1, -1, -1, MAXINT, 144},
								   {440, 360, 437, MAXINT, MAXINT, 302, 209, MAXINT},
				                  };*/

int custo[N_CIDADES][N_CIDADES] = {{MAXINT, 300, 727, 504, 904, 527, 420, 440},
								   {MAXINT, MAXINT, 331, 379, 453, 377, 407, 400},
								   {MAXINT, MAXINT, MAXINT, 221, 371, 460, 252, 361},
								   {MAXINT, MAXINT, MAXINT, MAXINT, 354, 680, 430, 600},
								   {MAXINT, 396, MAXINT, MAXINT, MAXINT, 664, 798, MAXINT},
								   {MAXINT, 285, MAXINT, MAXINT, MAXINT, MAXINT, 92, 515},
								   {440, 407, 330, 430, MAXINT, 90, MAXINT, 144},
								   {440, 360, 437, MAXINT, MAXINT, 302, 209, MAXINT}
				                  };

tSolucao melhorsolucao;
//int menorcusto = MAXINT;

void guardamelhorsolucao( tSolucao sol )
{
	int i;
	for (i=0; i<N_CIDADES; i++)
		melhorsolucao.cidades[i] = sol.cidades[i];
    melhorsolucao.custo = sol.custo;
}

int pertence(int cidade, int sol[], int pos) {
	int i;
	for (i=0; i<=pos; i++)
		if (cidade == sol[i])
			return 1;
	return 0;
}

tSolucao solver (int solucaoParcial[], int posicao, int custoAtual) {

	tSolucao menorcustolocal = {MAXINT,{-1,-1,-1,-1,-1,-1,-1,-1}};
	int origem = solucaoParcial[posicao];
	int todas_cidades = 1;
	tSolucao temp = {MAXINT,{-1,-1,-1,-1,-1,-1,-1,-1}};
	int cidade, cidade_aux;

	for (cidade=1; cidade<N_CIDADES; cidade++) {
		if ( !pertence(cidade, solucaoParcial, posicao) ) {
			todas_cidades = 0;
			printf("Cid: %d, Pos: %d ", cidade, posicao+1 );
			solucaoParcial [posicao+1] = cidade;
			temp = solver(solucaoParcial, posicao+1, custoAtual+custo[origem][cidade]);
			//if ( (temp < menorcustolocal) && ((posicao+1) == (N_CIDADES-1)) )
			if (temp.custo < menorcustolocal.custo)
			{
				menorcustolocal.custo = temp.custo;
                for (cidade_aux =0; cidade_aux < N_CIDADES; cidade_aux++)
                    menorcustolocal.cidades[cidade_aux]=temp.cidades[cidade_aux];
			}
		}
	}
	if (todas_cidades == 1)
    {
        menorcustolocal.custo = custoAtual + custo[origem][0];
        for (cidade =0; cidade < N_CIDADES; cidade++)
            menorcustolocal.cidades[cidade]=solucaoParcial[cidade];
    }
    return menorcustolocal;
}

main() {
	int cidade;
	int solucaolocal[N_CIDADES];
	solucaolocal[0] = Rio;
	melhorsolucao = solver (solucaolocal, 0, 0 );
	printf("Menor custo: %d\n Cidades: ", melhorsolucao.custo);
	for (cidade=0; cidade<N_CIDADES; cidade++) {
		printf("%d ", melhorsolucao.cidades[cidade]);
	}
	printf("\n");
}

