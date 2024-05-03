#lang slideshow
(define quadrado_circulo_cocentrico
  (lambda (lado elementos)
    (if (>= elementos 1)
      (cc-superimpose (rectangle lado lado) (circle lado) 
          (quadrado_circulo_cocentrico (/ lado 1.5) (- elementos 1)))
      (circle 0))))
