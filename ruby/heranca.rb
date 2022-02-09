# variaveis iniciadas com @ sao variaveis de instancia

class Pessoa
	def initialize(nome)
		@nome = nome
	end

	def nome
		@nome
	end
end

class Aluno < Pessoa
	def nota
		"Nota do aluno: #{rand(6..10)}"
	end
end

class Professor < Pessoa
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
professor_2.add_disciplinas("Redes 1", "FSI")


puts professor_1.disciplinas
puts professor_2.disciplinas
puts professor_3.disciplinas

aluno = Aluno.new("Nome do Aluno Aqui")
puts aluno.nome
puts aluno.nota