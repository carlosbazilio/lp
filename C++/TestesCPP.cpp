//============================================================================
// Name        : TestesCPP.cpp
// Author      : Bazilio
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>

using namespace std;

class ApplyFoo {
    float *const my_a;
	
public:
    void operator()( const int r ) {
        float *a = my_a;
        for( int i=0; i<r; ++i )
        	cout << a[i] << endl;
    }
    ApplyFoo( float a[] ) :
        my_a(a)
    {
    }
};

int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	float v[] = {10.5, 8, 20.3};
	ApplyFoo a(v);
	a (2);
	
	return 0;
}
