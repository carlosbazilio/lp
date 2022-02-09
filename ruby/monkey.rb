# monkey patching

str = "uma string qualquer"

puts str
puts "a string acima é uma objeto da classe #{str.class}"

#reverse é uma funcao padrao da biblioteca String
puts str.reverse


# !!! CUIDADO AO FAZER ISSO
class String
	def reverse
		self.upcase #agora reverse faz a mesma coisa q upcase
	end
end

puts str.reverse