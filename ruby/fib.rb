#iterativo
def fib_i(n)
	first, second = 0, 1
	n.times do
		first, second = second, first + second
	end
	first
end

#usando memoization
@cache = {}
def fib_m(n)
	return n if n<2

	@cache[n] ||= fib_m(n-1) + fib_m(n-2)  #https://stackoverflow.com/questions/995593/what-does-or-equals-mean-in-ruby/14697343
end

# recursivo (lento demais, dependendo da capacidade de processamento
# da máquina, a partir do indice 40 o método recursivo se mostra ineficiente)
def fib_r(n)
	return n if n<2
	fib_r(n-1)+fib_r(n-2)
end

puts "Digite um valor"
valor = gets.to_i
puts "Método Iterativo: #{fib_m(valor)}"
puts "Método Recursivo com Memoization: #{fib_i(valor)}"
puts "Método Recursivo: #{fib_r(valor)}"
