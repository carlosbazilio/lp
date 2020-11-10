# Funcao para buscar algum pico num vetor de numeros
def findpeak(numbers):
    if len(numbers) == 1:
    	return numbers[0]
    else:
        # Garantir que mais que 2 elementos (+1 e -1)
        #passem para a parte mais geral
        if len(numbers) == 2:
            return max (numbers[0], numbers[1])
    middle = len(numbers) / 2
    if (numbers[middle] > numbers[middle+1]):
        if (numbers[middle] > numbers[middle-1]):
            # Pico encontrado
            return numbers[middle]
        else:
            # Caso apenas o da direita seja menor,
            #busca-se pelo pico na esquerda
            return findpeak(numbers[:middle])
    else:
        return findpeak(numbers[middle:])
