use std::env;

fn fib(n: u32) -> u32 {
    fn fib_aux(n: u32, corr: u32,  prox: u32) -> u32 {
        match n {
            1 => corr,
            other => fib_aux(other-1, prox, corr+prox),
        }
    }
    fib_aux(n, 0, 1)
}

fn main() {
    let args: Vec<String> = env::args().collect();
    let arg = args[1].trim().parse();
    match arg {
        Ok(n) => println!("Fib({}) = {}\n", n, fib(n)),
        Err(_) => println!("Valor inválido!\n"),
    };
    // dbg!(args);
}
