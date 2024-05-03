f = function ()
    return
		function (x)   -- anonymous function
			return x + 1
		end
end

print (f()(1))

