
class Singleton(object):
	"""docstring for Singleton"""
	atributo = "abc"

	@staticmethod
	def imprime():
		print(Singleton.atributo)

Singleton.imprime()



		