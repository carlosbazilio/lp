# def fat(x)
# 	if x == 0
# 		1
# 	else
# 		x * fat(x-1)
# 	end
# end

# def funcaoteste
# 	x = 10
# end

# puts funcaoteste()

# puts 'hello, world'
# language = 'Ruby'
# puts "hello, #{language}"
# language = 'my Ruby'
# puts "hello, #{language}"

code = "Time.now"
code2 = "def fat(x)
	if x == 0
		1
	else
		x * fat(x-1)
	end
end"
result = eval(code2)
puts fat(10)


