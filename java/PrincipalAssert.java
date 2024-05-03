
class Mat {
	public static int fat (int x) {
		// if (x == 0)
		// 	return 1;
		// return x * fat(x - 1);
		int aux = 0;
		for (int i=2; i<=x; i++)
			aux *= i;
		return aux;
	}

	public static void testa_fat() {
		assert(Mat.fat(0) == 1);
		assert(Mat.fat(1) == 1);
		assert(Mat.fat(5) == 120);
		assert(Mat.fat(6) == 720);
	}
}

public class PrincipalAssert {	
	public static void main(String[] args) {
		Mat.testa_fat();
	}
}


