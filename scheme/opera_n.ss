#lang scheme
(define funcn
  (lambda (l f)
    (if (null? l)
        l
        (cons (f (car l)) (funcn (cdr l) f)))))
(define opera_n
  (lambda (n op)
    (lambda (x)
      (op x n))))
(define lista '(1 2 3))


