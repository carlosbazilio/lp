#include <iostream>

class X {
	public: 
		virtual void m () {
			std::cout << "m de X\n";
		};
};

class Y : public X {
	public: 
		void m () {
			std::cout << "m de Y\n";
		};
};

class Z {
	public:
		void m1 (X *x) {
			m2(x);
		}
		void m2 (X *x) {
			x->m();
		};
		void m2 (Y *y) {
			y->m();
		};
};

int main() {
	Z *z = new Z();
	X *y = new Y();
	z->m2(y);
	return 0;
}
