mulher(sara).
homem(abraao).
homem(isaque).
homem(ismael).
homem(esau).
homem(jaco).
homem(jose).
sexo(sara,feminino).
propriedade(sara,sexo,feminino).

progenitor(abraao,isaque).
progenitor(sara,isaque).
progenitor(abraao,ismael).
progenitor(abraao,jimmy).
progenitor(isaque,esau).
progenitor(isaque,jaco).
progenitor(jaco,jose).

p :- fail.

avo(X,Y) :- progenitor(X,Z),progenitor(Z,Y).
irmao(X,Y) :- progenitor(Z,X),progenitor(Z,Y),X \== Y.

ancestral(X,Z) :- progenitor(X,Z).
ancestral(X,Z) :- progenitor(X,Y),ancestral(Y,Z).

pairico(X) :- progenitor(X, Y), progenitor(X, Z), progenitor(X, W), 
			  Y \== Z, Y \== W, Z \== W, !.

netos(_, []).
netos(X, [Y]) :- avo(X, Y).
netos(X, [_ | Netos]) :- avo(X, Y), not(pertence(Y, Netos)), Netos is [Y].


inicio :- write('A= '),read(A),
         write('B= '),read(B),
         write('C= '),read(C),
         (A > 0,B > 0,C > 0,   /* must be positive */
         A < B+C,B < C+A,C < A+B, 
         !, write('These numbers are the edges of a triangle.'));
         write('These numbers are not the edges of a triangle.'), fail.
		
analisa :- write('A= '),read(A),
         write('B= '),read(B),
         write('C= '),read(C),
         (triangulo(A,B,C), !,
         write('These numbers are the edges of a triangle.'));
         write('These numbers are not the edges of a triangle.'), fail.
         
triangulo(A,B,C) :- A > 0,B > 0,C > 0,   /* must be positive */
                    A < B+C,B < C+A,C < A+B.
                    
                    
pertence(_, []) :- fail.
pertence(X, [X | _]).
pertence(X, [_ | Resto]) :- pertence(X, Resto).

intersecao(_, [], []).
intersecao([], _, []).
intersecao([Cab | Resto], L2, [Cab | L3]) :- pertence(Cab, L2), !, intersecao(Resto, L2, L3).
intersecao([_ | Resto], L2, L3) :- intersecao(Resto, L2, L3).




