void fat (int x, out int ac) {
	if (x > 0) {
		ac = ac * x;
		fat (x-1, out ac);
	}
}

int fat2 (int x) {
	if (x > 0) 
		return x * fat2(x-1);
	else
		return 1;
}

