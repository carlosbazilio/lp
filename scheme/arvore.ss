#lang scheme

(define arvore-vazia '())

(define vazia? null?)

(define folha? 
  (lambda (a)
    (not (list? a))))

(define cria-arvore 
  (lambda (r e d)
    (if (and (vazia? e) (vazia? d)) 
        r
        (cons r (cons e (cons d '()))))))

(define raiz
  (lambda (a) 
    (if (folha? a)
        a
        (car a))))

(define esq 
  (lambda (a)
    (if (folha? a)
        arvore-vazia
        (cadr a))))

(define dir 
  (lambda (a)
    (if (folha? a)
        arvore-vazia
        (caddr a))))

(define exibe
  (lambda (A)
    (if (vazia? A)
        (print A)
        (if (folha? A)
            (print (raiz A))
            (begin
              (print '@)
              (print (raiz A))
              (exibe (esq A))
              (exibe (dir A))
              (print '@))))))

(define arvore '(A (B () (E H I)) (C F (G J ()))))
  