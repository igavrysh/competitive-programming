package com.company;

public class Fib {
    public int T = 0;

    public int fib(int N) {
        T = 0;
        return f(N);
    }

    private int f(int N) {
        T++;
        if (N<2) {
            return N;
        }

        return f(N-1) + f(N-2);
    }
}
