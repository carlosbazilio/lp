-- type Circulo = (Float, Float, Float)
data Figura = Circulo Float Float Float
            | Quadrado Float Float Float
            | Triangulo Float Float
            deriving (Show)

area :: Figura -> Float
area (Circulo x y raio) = pi * raio * raio
area (Quadrado x y lado) = lado * lado
area (Triangulo base altura) = (base * altura) / 2

