package com.company;

public class Main {

    public static void test1() {
        Solution s = new Solution();
        int output = s.tribonacci(4);
        boolean passed = output == 4;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int output = s.tribonacci(25);
        boolean passed = output == 1389537;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }


    public static void main(String[] args) {
	      test1();
	      test2();
    }
}
