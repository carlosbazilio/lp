#include <iostream>
using namespace std;
#include <memory>

class Rectangle {
	int length;
	int breadth;

public:
	Rectangle(int l, int b) {
		length = l;
		breadth = b;
	}

	int area() {
		return length * breadth;
	}

	~Rectangle() {
		cout << "Removendo objeto" << endl;
	}
};

int main() {

	//////////////////////////////////////////////
	// UNIQUE
	unique_ptr<Rectangle> P1(new Rectangle(10, 5));
	cout << P1->area() << endl; // This'll print 50

	// unique_ptr<Rectangle> P2(P1);
	unique_ptr<Rectangle> P2;
	P2 = move(P1);

	// This'll print 50
	cout << P2->area() << endl;

	//////////////////////////////////////////////
	// SHARED
    shared_ptr<Rectangle> P3(new Rectangle(10, 5));
    // This'll print 50
    cout << P3->area() << endl;
 
    shared_ptr<Rectangle> P4;
    P4 = P3;
 
    // This'll print 50
    cout << P4->area() << endl;
 
    // This'll now not give an error,
    cout << P3->area() << endl;
 
    // This'll also print 50 now
    // This'll print 2 as Reference Counter is 2
    cout << P3.use_count() << endl;	

	//////////////////////////////////////////////
	// WEAK
	weak_ptr<Rectangle> P5 = P3;

    // This'll still print 2 as Reference Counter is 2
    cout << P5.use_count() << endl;	
    
	return 0;
}
