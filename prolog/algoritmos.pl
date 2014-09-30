/*
Linha de comando:
swipl
consult('algoritmos.pl').
*/

busca_bin(_, []) :- fail.
busca_bin(X, [X | _]).
busca_bin(X, [Cab, LE, LD]) :- (X < Cab, busca_bin(X, LE)) ;
                               (X > Cab, busca_bin(X, LD)).

push(X, L, [X | L]).
pop([X | L], X, L).
top([X | _], X).
tam([], 0).
tam([_ | L], N) :- tam(L, M), N is M + 1.

