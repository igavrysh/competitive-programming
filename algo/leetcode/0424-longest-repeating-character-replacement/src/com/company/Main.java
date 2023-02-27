package com.company;

public class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolutionBS1();
        testSolutionBS2();
    }

    public static void testSolution1() {
        String s = "ABAB";
        int k = 2;
        SolutionBruteForce sol = new SolutionBruteForce();
        int output = sol.characterReplacement(s, k);
        boolean passed = output == 4;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        String s = "AABABBA";
        int k = 1;
        SolutionBruteForce sol = new SolutionBruteForce();
        int output = sol.characterReplacement(s, k);
        boolean passed = output == 4;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS1() {
        String s = "ABAB";
        int k = 2;
        SolutionBS sol = new SolutionBS();
        int output = sol.characterReplacement(s, k);
        boolean passed = output == 4;
        System.out.println("testSolutionBS1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionBS2() {
        String s = "AABABBA";
        int k = 1;
        SolutionBS sol = new SolutionBS();
        int output = sol.characterReplacement(s, k);
        boolean passed = output == 4;
        System.out.println("testSolutionBS2: " + (passed ? "passed" : "failed"));
    }
}