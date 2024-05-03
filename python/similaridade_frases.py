import re
import string
import numpy as np

corpus = np.array([
	'O importante não é vencer todos os dias, mas lutar sempre.',
	'Maior que a tristeza de não haver vencido é a vergonha de não ter lutado!',
	'É melhor conquistar a si mesmo do que vencer mil batalhas.',
	'Oi eu sou o goku!',
	'Oi eu não sou o goku!!!',
	'Oi seu nome é goku (?)'])

def clear_text(text):
	lowertext = [phrase.lower() for phrase in text]
	pattern = "[{}]".format(string.punctuation)
	lowertext = [[re.sub(pattern, "", word) for word in phrase.split()] for phrase in lowertext]
	lowertext = [[word for word in phrase if len(word)>1] for phrase in lowertext]
	lowertext = [' '.join(phrase) for phrase in lowertext]
	return np.array(lowertext)

def text_all(text):
	text_set = set()
	for word in [phrase.split() for phrase in text]:
		text_set.update(word)
	return np.array(list(text_set))

def fit_transform(text):
	return [1 if word in text.split() else 0 for word in text_all(clear_text(corpus))]

def cosine_similarity(v, w):
	return np.dot(v, w) / np.sqrt(np.dov(v, v)*np.dot(w, w))


