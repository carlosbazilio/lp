
'''
Neste exercicio voces devem adicionar as seguintes
caracteristicas na classe Luminaria:
1) Alterar construtor para que, caso nao informado, 
a luminaria comece apagada.
2) Implementar metodo adicionarLampada().
3) Redefinir metodo __str__ herdado da classe object.
4) Definir a propriedade acesa, de forma que ao 
acender uma luminaria, todas as lampadas sejam acesas.
Idem para quando forem apagadas.
5) Ao final do arquivo, criar 4 lampadas com os
valores:
Led de 60w
Led de 50w
Fluorescente de 100w
Incandescente de 120w
6) Em seguida, criar uma luminaria e adicionar
as lampadas de led a esta luminaria
7) Criar uma lista no prompt. Inserir nesta lista
a luminaria e as lampadas fluorescente e incandescente.
8) Percorrer esta lista, imprindo cada objeto que
nela existe.
'''

class Lampada(object):

	def __init__(self, t, p, a = False):
		self.potencia = p
		self.tecnologia = t
		self._acesa = a
		self._funcionando = True

	def __str__(self):
		saida = 'Lampada %s com potencia de %s watts\n' % \
		(self.tecnologia, self.potencia)
		return saida

	#get
	@property
	def acesa(self):
		print("Dentro do metodo acesa!")
		return self._acesa

	#set
	@acesa.setter
	def acesa(self, valor):
		print("Dentro do metodo set de acesa!")
		if (self._funcionando):
			self._acesa = valor

	#get
	@property
	def funcionando(self):
		print("Dentro do metodo funcionando!")
		return self._funcionando

	#set
	@funcionando.setter
	def funcionando(self, valor):
		print("Dentro do metodo set de funcionando!")
		self._funcionando = valor
		if (not valor):
			self._acesa = False

	def setCor(self, valor):
		self._cor = valor

	def getCor(self):
		return self._cor


class Luminaria(object):

	def __init__(self, a = False):
		self.lampadas = []
		self.acesa = a

	#def adiciona(self, l):
	#	self.lampadas.append(l)

	def adiciona(self, t, p, a):
		self.lampadas.append(Lampada(t, p, a))

	


