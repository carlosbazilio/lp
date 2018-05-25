function fib()
	anterior = 0
	corrente = 1
	while (true) do
		coroutine.yield(corrente) -- Interrompe a execução da corotina,
		-- devolvendo o valor passado por parâmetro
		corrente = anterior + corrente
		anterior = corrente - anterior
	end
end

function principal()
	co = coroutine.create(fib) -- Cria uma corotina com a função fib
	print ("Digite um número para cálculo da série de Fibonacci")
	num = io.read("*n") -- Lê um número
	cont = 1
	while (cont <= num) do
		print (cont .. "o. = ", coroutine.resume(co)) -- .. Concatena strings
		-- coroutine.resume desvia a execução para a corotina
		cont = cont+1
	end
end

principal() -- Início do programa


		