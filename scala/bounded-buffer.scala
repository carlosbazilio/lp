class BoundedBuffer[A](N: Int) { 
	var in = 0, out = 0, n = 0 
	val elems = new Array[A](N)

	def put(x: A) = synchronized { 
		while (n >= N) wait() 
		elems(in) = x ; in = (in + 1) % N ; n = n + 1 
		if (n == 1) notifyAll()
	}

	def get: A = synchronized { 
		while (n == 0) wait() 
		val x = elems(out) ; out = (out + 1) % N ; n = n - 1 
		if (n == N - 1) notifyAll() 
		x
	}
}

val buf = new BoundedBuffer[String](10) 
spawn { 
	while (true) { 
		val s = produceString
		buf.put(s) 
	} 
} 
spawn { 
	while (true) { 
		val s = buf.get
		consumeString(s) 
	} 
}

