// C++ program to demonstrate working of a Pointers
#include <iostream>
#include <memory>
using namespace std;

class Rectangle {
private:
	int length;
	int breadth;
};

void fun()
{
	// By taking a pointer p and
	// dynamically creating object
	// of class rectangle
	Rectangle* p = new Rectangle();
	//unique_ptr<Rectangle> p(new Rectangle());
}

int main()
{
	// Infinite Loop
	while (1) {
		fun();
	}
}

