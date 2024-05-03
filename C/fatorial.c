#include "fatorial.h"

int fat (int x) {
	if (x == 0)
		return 1;
	else
    	return x * fat(x - 1);
}
