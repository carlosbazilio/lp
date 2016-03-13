function fat (x)
	if x <= 1 then
		return 1
	end
	return x * fat (x-1)
end

function fat2 (x)
	res = 1
	while (x >= 1) do
		res = res * x
		x = x-1
	end
	return res
end

print (fat2(5))

