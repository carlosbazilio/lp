#lang scheme
(define uniao
  (lambda (conj1 conj2)
    (if (null? conj1)
        conj2
        (if (pertence? (car conj1) conj2)
            (uniao (cdr conj1) conj2)
            (cons (car conj1) (uniao (cdr conj1) conj2))))))

(define pertence?
  (lambda (el conj)
    (if (null? conj)
        '#f
        (if (= (car conj) el)
            '#t
            (pertence? el (cdr conj))))))

(define tamanho
  (lambda (conj)
    (if (null? conj)
        0
        (+ 1 (tamanho (cdr conj))))))