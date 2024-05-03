# variáveis iniciadas com @ são variáveis de instância
# no ruby, a última linha de uma função sempre é o retorno

# criado um módulo, e importado nas classes que usarão suas funções
module Pessoa
	def initialize(nome)
		@nome = nome
	end

	def nome
		@nome
	end
end

class Aluno
	include Pessoa

	def nota
		"Nota do aluno: #{rand(6..10)}"
	end
end

class Professor
	include Pessoa

	def initialize(nome)
		super(nome)
		@disciplinas = []
	end

	def add_disciplinas(*disc)
		@disciplinas.push(*disc)
	end

	def disciplinas
		return "Disciplinas do professor #{@nome}: #{@disciplinas}" unless @disciplinas.empty?
		"Não há disciplinas cadastradas para o professor #{@nome}"
	end
end

professor_1 = Professor.new("Bazilio")
professor_2 = Professor.new("Leandro")
professor_3 = Professor.new("Eduardo")

professor_1.add_disciplinas("Linguagens de Programação", "Programação Web")
professor_3.add_disciplinas("Técnicas de Programação Avançada")

puts professor_1.disciplinas
puts professor_2.disciplinas
puts professor_3.disciplinas

aluno = Aluno.new("Nome do Aluno Aqui")
puts aluno.nome
puts aluno.nota