%Hernandez Reyes Diego Alberto 3VC5

%Pruebas con PROLOG

female(pam).

female(liz).

female(pat).

female(ann).

female(eva).

male(jim).

male(bob).

male(tom).

male(peter).

parent(pam,bob).

parent(tom,bob).

parent(tom,liz).

parent(bob,ann).

parent(bob,pat).

parent(pat,jim).

parent(bob,peter).

parent(peter,jim).

parent(liz, eva).

mother(X,Y):- parent(X,Y),female(X).

father(X,Y):- parent(X,Y),male(X).

haschild(X):- parent(X,_).

sister(X,Y):- parent(Z,X),parent(Z,Y),female(X),X\==Y.

brother(X,Y):- parent(Z,X),parent(Z,Y),male(X),X\==Y.

grandma(X, Y) :- parent(Z, Y), parent(X, Z), female(X), X \== Y.

grandpa(X, Y) :- parent(Z, Y), parent(X ,Z), male(X), X \== Y.

cousinf(X, Y) :- parent(Z, X), parent(A, Y), (brother(Z, A) ; sister(Z, A) ; sister(A, Z) ; brother(A, Z)), female(X), X \== Y.

cousinm(X, Y) :- parent(Z, X), parent(A, Y), (brother(Z, A) ; sister(Z, A) ; sister(A, Z) ; brother(A, Z)), male(X), X \== Y.

nephew(X, Y) :- parent(Z, X), (brother(Z, Y) ; sister(Z, Y); brother(Y, Z) ; sister(Y, Z)), male(X), X \== Y.