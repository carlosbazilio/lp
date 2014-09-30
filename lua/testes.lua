-- Nesta linguagem, tudo que está fora da definição de funções é chamado em sequência

-- io.write("Hello world, from ",_VERSION,"!\n")

x = 5

function novoContador ()
	local i = 0
    return
		function ()   -- anonymous function
			i = i + x
            return i
		end
end

function chamaContador ()
	return novoContador ()
end

a = 10
b = a + 10
b = b .. "abc"
-- print(b) --> 20abc

c1 = chamaContador()
print(c1()) --> 5
print(c1()) --> 10
print(c1()) --> 15

print (_G["a"])
print (_G["b"])

y = {c1 = 5, c2 = -4}

print ("Valor da soma dos campos de y: " .. y.c1 + y.c2)

array = { "a", "b", "c", "d" }
print("Valor do array na posicao 2: " .. array[2])
print("Tamanho do array: " .. #array)
array[5] = "e"
print("Tamanho do array: " .. #array)

point = { x = 10, y = 20 }
print("Valor do campo x de point: " .. point["x"])
print("Valor do campo x de point: " .. point.x)

