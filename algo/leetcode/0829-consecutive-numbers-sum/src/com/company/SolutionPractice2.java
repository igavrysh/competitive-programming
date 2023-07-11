package com.company;

public class SolutionPractice2 {

    public int consecutiveNumbersSum(int n) {
        int counter = 0;
        int nx2 = n*2;
        for (int y = 1; (y+1)*y <= nx2; y++) {
            if ((2*n-(y+1)*y) % (2*y) == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        testSolutinoPractice2_1();
        testSolutinoPractice2_2();
        testSolutinoPractice2_3();
    }

    public static void testSolutinoPractice2_1() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.consecutiveNumbersSum(5);
        boolean passed = output == 2;
        System.out.println("testSolutinoPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutinoPractice2_2() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.consecutiveNumbersSum(9);
        boolean passed = output == 3;
        System.out.println("testSolutinoPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutinoPractice2_3() {
        SolutionPractice2 s = new SolutionPractice2();
        int output = s.consecutiveNumbersSum(15);
        boolean passed = output == 4;
        System.out.println("testSolutinoPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
