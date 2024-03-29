/**
 * Written by Computer Science and Engineering 202211342 Yulwon Rhee
 * Development environment:
 * Microsoft Visual Studio Community 2022 (64-bit) v17.5.2 @ Windows 11 22H2(22621.1265)
 */
#include <stdio.h>

// 1-1. Recursion Version of the Factorial
long long factorialRecursive(int n) {
    return n == 0 || n == 1 ?
        1 :
        n * factorialRecursive(n - 1);
}

// 1-2. Iterative Version of the Factorial
long long factorialIterative(int n) {
    long long result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

// 2-1. Recursive Version of the Fibonacci
int fibonacciRecursive(int n) {
    return n == 0 || n == 1 ?
        n :
        fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
}

// 2-2. Iterative Version of the Fibonacci
int fibonacciIterative(int n) {
    int a = 0, b = 1, c;
    if (n == 0) return a;
    for (int i = 2; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

int main() {
    // 1-3. Factorial 1 to 10
    for (int i = 1; i <= 10; i++) {
        printf("Recursive %d!\t= %lld\n", i, factorialRecursive(i));
        printf("Iterative %d!\t= %lld\n", i, factorialIterative(i));
    }

    
    // 2-3. Fibonacci 1 to 10
    for (int i = 1; i <= 10; i++) {
        printf("Recursive fib(%d)\t= %d\n", i, fibonacciRecursive(i));
        printf("Iterative fib(%d)\t= %d\n", i, fibonacciIterative(i));
    }
    
    // 3, 5. Testing Stack Overflow with Recursive Function
    for (int i = 1; i < 10000; i *= 2) {
        printf("%d!\t= %lld\n", i, factorialRecursive(i));
    }

    // 4. Testing Stack Overflow with Iterative Function
    for (int i = 1; i < 10000; i *= 2) {
        printf("%d!\t= %lld\n", i, factorialIterative(i));
    }

    return 0;
}