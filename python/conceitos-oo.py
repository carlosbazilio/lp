'''
Autor: Carlos Bazilio
Descricao:
Este programa ilustra: 
* Uma hierarquia de classes em Python e como 
classes abstratas podem ser implementadas
* Definição e uso de propriedades para
encapsulamento de atributos.

Python disponibiliza o modulo abc para implementar 
classes abstratas
ABC e a classe abstrata
abstractmethod e a anotacao para indicar qual
metodo e abstrato'''

from abc import ABCMeta, abstractmethod

class Iluminavel:
	__metaclass__ = ABCMeta

	@abstractmethod
	def acesa(self, valor):
		pass

	@abstractmethod
	def acesa(self):
		pass

class Lampada(Iluminavel):
	def __init__(self, t, p):
		self.potencia = p
		self.tecnologia = t
		self._acesa = False

	@property
	def acesa(self):
		return self._acesa

	@acesa.setter
	def acesa(self, valor):
		#print "Dentro de acesa"
		self._acesa = valor

class Luminaria(Iluminavel):
	def __init__(self):
		self.lampadas = []
		self._acesa = False

	def adicionaLampada(self, l):
		self.lampadas.append(l)

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

l1 = Lampada("led", 60)
l2 = Lampada("fluorescente", 100)
l3 = Lampada("incandescente", 120)
