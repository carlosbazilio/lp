#include <iostream>
#include <memory>

int main()
{
    // OLD, problem with dangling pointer
    // PROBLEM: ref will point to undefined data!

    int* ptr = new int(10);
    int* ref = ptr;
    delete ptr;

    // NEW
    // SOLUTION: check expired() or lock() to determine if pointer is valid

    // empty definition
    std::shared_ptr<int> sptr, fakeweak;

    // takes ownership of pointer
    sptr.reset(new int);
    *sptr = 10;

    // get pointer to data without taking ownership
    std::weak_ptr<int> weak1 = sptr;

    fakeweak = sptr;
    // fakeweak = nullptr;

    // deletes managed object, acquires new pointer
    sptr.reset(new int);
    *sptr = 5;

    // get pointer to new data without taking ownership
    std::weak_ptr<int> weak2 = sptr;

    // weak1 is expired!
    if(auto tmp = weak1.lock())
        std::cout << "weak1 value is " << *tmp << '\n';
    else
        std::cout << "weak1 is expired\n";
    
    // weak2 points to new data (5)
    if(auto tmp = weak2.lock())
        std::cout << "weak2 value is " << *tmp << '\n';
    else
        std::cout << "weak2 is expired\n";
}