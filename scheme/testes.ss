#lang scheme
(define d 50)
(define contas '((faray 1 1000) (yasmin 2 5000) (stefan 3 8000)))
(define saldo2
  (lambda (l n)
    (if (null? l)
        0
        (if (= (cadar l) n)
            (cons (caar l) (cons (caddar l) '()))
            (saldo2 (cdr l) n)))))
(define saldo
  (lambda (l nome)
    (if (null? l)
        0
        (if (equal? (caar l) nome)
            (caddar l)
            (saldo (cdr l) nome)))))
(define montante
  (lambda (l)
    (if (null? l)
        0
        (+ (caddar l) (montante (cdr l))))))
(define saldo-medio
  (lambda (l)
    (/ (montante l) (length l))))
(define especiais
  (lambda (l)
    (if (null? l)
        '()
        (if (>= (caddar l) (saldo-medio contas))
            (cons (caar l) (especiais (cdr l)))
            (especiais (cdr l))))))
(let ((a 30)) (* a 20))
(define media 
  (lambda (x y z) 
    (/ (+ x y z) 3)))
(define especial?
  (lambda (l)
    (if (not (null? l))
        (> (cadr l) 5000)
        "lista vazia")))
(define soma-pares
  (lambda (x)
    (if (null? x)
        0
        (if (even? (car x))
            (+ (car x) (soma-pares (cdr x)))
            (soma-pares (cdr x))))))
(define soma-impares
  (lambda (x)
    (if (null? x)
        0
        (if (odd? (car x))
            (+ (car x) (soma-impares (cdr x)))
            (soma-impares (cdr x))))))
(define func-generica
  (lambda (x p? f felem)
    (if (null? x)
        0
        (if (p? (felem x))
            (f (felem x) (func-generica (cdr x) p? f felem))
            (func-generica (cdr x) p? f felem)))))
(define numeros '(1 2 3 4 5))
(define multiplo4?
  (lambda (x)
    (= (remainder x 4) 0)))
(define verdade?
  (lambda (x)
    '#t))