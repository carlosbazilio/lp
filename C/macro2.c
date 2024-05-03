#include "stdio.h"
#define ___ printf
#define _(__) ___("%d",__); ___("%d",__); 


void f(int x) {
	_(x)
}

int main() {
	f(10);
	// printf("%d\n", f(10));
}
