#lang scheme
(define produtos
'((1 "teclado" 50.00 1)
  (2 "monitor" 450.00 1)
  (3 "tv 54'" 4600.00 2)
  (4 "fogao 6 bocas" 1100.00 3)
  (5 "laptop" 2000.00 1)))

(define soma
  (lambda (x f)
    (if (null? x)
        0
        (+ (f x)
           (soma (cdr x) f)))))

(define preco
  (lambda (prods)
    (caddar prods)))

(define tipos
'((1 "informatica")
  (2 "eletrodomesticos")
  (3 "linhabranca")))

(define maior_valor
  (lambda (t)
    (maior_valor_aux t 0 '())))

(define maior_valor_aux
  (lambda (t val nome)
    (if (null? t)
        nome
        (if (> (caddar t) val)
            (maior_valor_aux (cdr t) (caddar t) (cadar t))
            (maior_valor_aux (cdr t) val nome)))))

(define valor_produto
  (lambda (t cod)
    (if (null? t)
        0
        (if (= (caar t) cod)
            (caddar t)
            (valor_produto (cdr t) cod)))))

(define soma_carrinho
  (lambda (c)
    (soma_carrinho_aux c produtos)))

(define soma_carrinho_aux
  (lambda (c prod)
    (if (null? c)
        0
        (+ (* (valor_produto prod (caar c)) (cadar c))
           (soma_carrinho_aux (cdr c) prod)))))
    
(define produtos_tipo
  (lambda (tipo tps prds)
    (if (null? tps)
        '()
        (if (equal? (cadar tps) tipo)
            (lista_produtos (caar tps) prds)
            (produtos_tipo tipo (cdr tps) prds)))))

(define lista_produtos
  (lambda (cod prds)
    (if (null? prds)
        '()
        (if (= (car (cdddar prds)) cod)
            (cons (cadar prds) (lista_produtos cod (cdr prds)))
            (lista_produtos cod (cdr prds))))))
