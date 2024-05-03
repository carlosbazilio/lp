class Pessoa(object):
	"""docstring for Pessoa"""
	def __init__(self, nome):
		super(Pessoa, self).__init__()
		self.nome = nome

	def __str__(self):
		return self.nome

p = Pessoa("Bazilio")
print(p)
		