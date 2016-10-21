//
//  main.c
//  FunctionPointers
//
//  Created by Ayrton Cavalieri on 18/09/2016.
//  Thanks to Tomaz Canabrava, who showed me this idea, and KDE, who helped me
//  in Randa, Switzerland.
//  Copyright © 2016 AyrtonC. All rights reserved.
//

/*
 The idea of this is to show a template of how to return functions in C.
 One use of this is to simplify the design of state machines.
 It can also find a use in simulate functional programming in C.
 */

#include <stdio.h>
#include <stdlib.h>

typedef void* (*func)(void *ptr);

void* function2(void *ptr)
{
    //Write function body here.
    printf("function2\n");
    return NULL;
}

void* function1(void *ptr)
{
    //Write function body here.
    printf("function1\n");
    return function2;
}

/*
 Function f is a wrapper to pretend it's running on an ADT.
 Merely formality.
 */

void f(void *p){
    //Define entry point.
    func ptr = (func)function1;
    
    //In this loop, execute functions…
    //You can select the next function by
    while(ptr != NULL){
        ptr = (func)ptr(p);
    }
    
}

int main(int argc, const char * argv[]) {
    void *nano = NULL;
    //Call wrapper.
    f(nano);
    return 0;
}
