def verificaTipo(tipo):
	def verificador(metodo_antigo):
		def novo_metodo(objeto_self, objeto_a_ser_adicionado):
			if isinstance(objeto_a_ser_adicionado, tipo):
				metodo_antigo(objeto_self, objeto_a_ser_adicionado)
			else:
				raise TypeError("Uso indevido de tipo!")
		return novo_metodo
	return verificador

# Dentro de Luminaria
@verificaTipo(Lampada)
	def adicionaLampada(self, l):
		self.lampadas.append(l)

# (1a Substituição)
# Funcao verificaTipo recebendo Lampada como parametro
@verificaTipo(Lampada) 

def verificador(metodo_antigo):
	def novo_metodo(objeto_self, objeto_a_ser_adicionado):
		if isinstance(objeto_a_ser_adicionado, Lampada): # (1) tipo = Lampada
			metodo_antigo(objeto_self, objeto_a_ser_adicionado)
		else:
			raise TypeError("Uso indevido de tipo!")
	return novo_metodo

# (2a Substituição)
# Funcao verificador recebendo adicionaLampada como parametro
def adicionaLampada(self, l):
	self.lampadas.append(l)

def novo_metodo(objeto_self, objeto_a_ser_adicionado):
	# (1a) tipo = Lampada
	if isinstance(objeto_a_ser_adicionado, Lampada):
		# (2a) metodo_antigo = adicionaLampada
		adicionaLampada(objeto_self, objeto_a_ser_adicionado)
	else:
		raise TypeError("Uso indevido de tipo!")



