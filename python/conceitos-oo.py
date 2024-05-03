'''
Autor: Carlos Bazilio
Descricao:
Este programa ilustra: 
* Uma hierarquia de classes em Python e como 
classes abstratas podem ser implementadas
* Definicao e uso de propriedades para
encapsulamento de atributos.
* Tratamento de Excecoes

Python disponibiliza o modulo abc para implementar 
classes abstratas
ABC e a classe abstrata
abstractmethod e a anotacao para indicar qual
metodo e abstrato'''

from abc import ABCMeta, abstractmethod

# Classe abstrada em Python 2
class Iluminavel:
	__metaclass__ = ABCMeta

	def __init__(self, t):
		self.teste = t
		pass

	# Metodo abstrato
	@abstractmethod
	def acesa(self, valor):
		pass

	@abstractmethod
	def acesa(self):
		pass

	@abstractmethod
	def padrao(self):
		return "Comportamento padrao"

class Lampada(Iluminavel):
	# Construtor com valor default
	def __init__(self, t = "indefinida", p = 0, a = False):
		self.potencia = p
		self.tecnologia = t
		self._acesa = a
	
	# Redefinicao do metodo string herdado de object
	def __str__(self):
		saida = 'Lampada %s com potencia de %s watts\n' % \
		(self.tecnologia, self.potencia)
		saida = saida + super(Lampada, self).__str__()
		return saida

	# Definicao de uma propriedade (metodo get)
	@property
	def acesa(self):
		print ("Dentro do get de acesa")
		return self._acesa

	# Definicao de uma propriedade (metodo set)
	@acesa.setter
	def acesa(self, valor):
		print ("Dentro do set de acesa")
		self._acesa = valor

	def padrao(self):
		return "Comportamento em Lampada \n" + \
		"Comportamento da superclasse: " + \
		super(Lampada, self).padrao()

# Implementacao de um decorador para verificar tipos
def verificaTipo(tipo):
	def verificador(metodo_antigo):
		def novo_metodo(objeto_self, objeto):
			if isinstance(objeto, tipo):
				metodo_antigo(objeto_self, objeto)
			else:
				raise TypeError("Uso indevido de tipo!")
		return novo_metodo
	return verificador

class Luminaria(Iluminavel):
	def __init__(self, status = False):
		self.lampadas = []
		self._acesa = status

	# Uso do decorator definido acima
	@verificaTipo(Lampada)
	def adicionaLampada(self, l):
		self.lampadas.append(l)

	@verificaTipo(Lampada)
	def __add__(self, l):
		self.lampadas.append(l)

	def __str__(self):
		saida = ''
		for l in self.lampadas:
			saida = saida + str(self.lampadas.index(l)) + ': ' + str(l) + '\n'
		return saida

	@property
	def acesa(self):
		status_inicial = False
		for l in self.lampadas:
			status_inicial = status_inicial or l.acesa
		return status_inicial

	@acesa.setter
	def acesa(self, valor):
		for l in self.lampadas:
			l.acesa = valor

	def listagem5Primeiras(self):
		for i in range(5):
			# Tratando excecoes
			try:
				print (self.lampadas[i])
			except IndexError:
				print ("Empty")

l1 = Lampada("led", 60)
l2 = Lampada("fluorescente", 100)
l3 = Lampada("incandescente", 120)

l1.acesa = True

print(l1.__str__())

print(l1.padrao())

l4 = Iluminavel(10)

