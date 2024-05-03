voo(1,rio,saopaulo).
voo(2,saopaulo,curitiba).
voo(3,curitiba,portoalegre).
voo(4,vitoria,rio).
% conexaodireta(X,Y) :- voo(_,X,Y);voo(_,Y,X).
conexaodireta(X,Y) :- voo(_,X,Y).
conexao(_,_,[]) :- fail.
conexao(X,Y,_) :- conexaodireta(X,Y).
conexao(X,Y,[Cid1 | Resto]) :- (conexaodireta(X,Cid1),conexao(Cid1,Y,Resto));
							   (conexao(X,Y,Resto)).
							   