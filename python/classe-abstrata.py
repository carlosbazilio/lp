'''
Autor: Carlos Bazilio
Descricao:
Este programa ilustra uma hierarquia de classes
em Python e como classes abstratas podem ser
implementadas

Python disponibiliza o modulo abc para implementar 
classes abstratas
ABC e a classe abstrata
abstractmethod e a anotacao para indicar qual
metodo e abstrato'''

from abc import ABCMeta, abstractmethod

class Iluminavel:
	__metaclass__ = ABCMeta

	@abstractmethod
	def acender(self):
		pass

	@abstractmethod
	def apagar(self):
		pass

	@abstractmethod
	def status(self):
		pass

class Lampada(Iluminavel):
	def __init__(self, t, p):
		self.potencia = p
		self.tecnologia = t
		self.acesa = False

	def acender(self):
		self.acesa = True

	def apagar(self):
		self.acesa = False

#	def status(self):
#		return self.acesa

class Luminaria(Iluminavel):
	def __init__(self):
		self.lampadas = []
		self.acesa = False

	def adicionaLampada(self, l):
		self.lampadas.append(l)

	def acender(self):
		for l in self.lampadas:
			l.acender()

	def apagar(self):
		for l in self.lampadas:
			l.apagar()

	def status(self):
		status_inicial = False
		for l in self.lampadas:
			status_inicial = status_inicial or l.status()
		return status_inicial

l1 = Lampada("led", 60)
l2 = Lampada("fluorescente", 100)
l3 = Lampada("incandescente", 120)
