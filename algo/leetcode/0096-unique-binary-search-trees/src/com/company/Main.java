package com.company;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution s = new Solution();
        int output = s.numTrees(3);
        boolean passed = output == 5;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int output = s.numTrees(1);
        boolean passed = output == 1;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}