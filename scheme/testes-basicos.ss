#lang scheme
(define media 
  (lambda (x y z) 
    (/ (+ x y z) 3)))

(define par?
  (lambda (x)
    (= (remainder x 2) 0)))

(define meuif
  (lambda (cond ramoverdade ramofalso)
    (if cond
        ramoverdade
        ramofalso
        )))