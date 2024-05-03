struct Retangulo {
    lado1 : u32,
    lado2 : u32
}

struct Circulo {
    raio : u32
}

enum Figura {
    Ret(Retangulo),
    Circ(Circulo),
}

impl Retangulo {
    fn area(&self) -> f32 {
        return (self.lado1 as f32) * (self.lado2 as f32);
    }
}

impl Circulo {
    fn area(&self) -> f32 {
        return (self.raio as f32) * (self.raio as f32) * std::f32::consts::PI;
    }
}

impl Figura {
    fn area(&self) -> f32 {
        match self {
            Figura::Ret(r) => r.area(),    
            Figura::Circ(c) => c.area(),
        }
    }
}

fn main() {
    let quadrado = Figura::Ret(Retangulo { lado1: 10, lado2: 20 });
    let circulo = Figura::Circ(Circulo { raio: 30 });

    println!("Tamanho do quadrado: {}", quadrado.area());
    println!("Tamanho do círculo: {}", circulo.area());
}
