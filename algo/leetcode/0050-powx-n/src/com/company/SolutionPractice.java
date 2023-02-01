package com.company;

public class SolutionPractice {
    public double myPow(double x, int n) {
        if (x == 0) {
            if (n<0) {
                return Double.NEGATIVE_INFINITY;
            }
            return 0;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }

        if (x==1) {
            return 1;
        }

        if (x == -1.0) {
            return ((n & 1) == 1 ? -1 : 1);
        }

        if (n < Integer.MIN_VALUE/2) {
            return 0.0;
        }

        if (n < 0) {
            return myPow(1/x, -n);
        }

        double result = x; 
        long k = 1;
        while (k != n) {
            if (k*2 <= n) {
                result*=result;
                k*=2;
            }

            if (k < n) {
                result*=x;
                k+=1;
            }
        }
        return result;
    }
}
