#lang scheme
(define voo
  (lambda (orig dest)
    (or (and (equal? orig 'rio) (equal? dest 'saopaulo))
        (and (equal? orig 'saopaulo) (equal? dest 'curitiba))
        (and (equal? orig 'curitiba) (equal? dest 'portoalegre)))))

(define conexao
  (lambda (orig dest cidades)
    (conexao2 orig dest cidades '() '#f)))

(define conexao2
  (lambda (orig dest cidades pendentes mudou)
    (if (null? cidades)
        (if (null? pendentes)
            (voo orig dest)
            (if (equal? mudou '#t)
                (conexao2 orig dest pendentes '() '#f)
                '#f))
        (or (voo orig dest)
            (and (voo orig (car cidades)) 
                 (conexao2 (car cidades) dest (cdr cidades) pendentes '#t))
            (conexao2 orig dest (cdr cidades) (cons (car cidades) pendentes) mudou)))))