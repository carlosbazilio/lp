#lang scheme
(define Tab '((1 3 4) (3 5 2 7) (2 24 1 8) (223 233 42 230)))
(define menorLista
  (lambda (L)
    (if (null? L) 
        -1
        (if (null? (cdr L))
            (car L)
            (menorLista (cons (min (car L) (car (cdr L))) (cdr (cdr L))))))))
        
(define mapeia
  (lambda (L f)
    (if (null? L)
        L
        (cons (f (car L)) (mapeia (cdr L) f))
        )))

(define mult2
  (lambda (x n)
    (* x n)))

(define mult_n
  (lambda (n)
    (lambda (x) (* x n))))