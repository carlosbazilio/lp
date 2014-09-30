function incr (z)
	return z + 1
end
function g (z, f)
	return z + 10, f(z)
end
f = g
g = 10
y, w = f(g, incr)
print ('y=', y, 'w=', w)

