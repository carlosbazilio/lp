function foo(a)
	print("foo", a)
	return coroutine.yield(2*a)
end

co = coroutine.create(
	function(a,b)
		print("1: co_body", a, b)
		local r = foo(a+1)
		print("2: co_body", r)
		local r, s = coroutine.yield(a+b,a+b)
		print("3: co_body", r, s)
		return b, "end"
	end)

print("main", coroutine.resume(co,1,10))
print("main", coroutine.resume(co,"vh"))
print("main", coroutine.resume(co,"x","y"))
print("main", coroutine.resume(co,"x","y"))

		