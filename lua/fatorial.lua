-- !(x) = 1, x == 1
-- !(x) = x * !(x-1), c.c.

function fat (x)
	if x <= 1 then
		return 1
	end
	return x * fat (x-1)
end

function fat_iter(x)
    aux = 1;
	while (x > 1) do
		aux = aux * x
		x = x - 1
	end
	return aux 
end

print (fat(20))

