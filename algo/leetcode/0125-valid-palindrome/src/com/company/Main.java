package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
        testSolution4();

        testSolutionMemoryOptimized1();
    }

    public static void testSolution1() {
        String input = "A man, a plan, a canal: Panama";
        Solution s = new Solution();
        boolean output = s.isPalindrome(input);
        boolean passed = output == true;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        String input = "race a car";
        Solution s = new Solution();
        boolean output = s.isPalindrome(input);
        boolean passed = output == false;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        String input = " ";
        Solution s = new Solution();
        boolean output = s.isPalindrome(input);
        boolean passed = output == true;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4() {
        String input = "0P";
        Solution s = new Solution();
        boolean output = s.isPalindrome(input);
        boolean passed = output == false;
        System.out.println("testSolution4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionMemoryOptimized1() {
        String input = "A man, a plan, a canal: Panama";
        SolutionMemoryOptimized s = new SolutionMemoryOptimized();
        boolean output = s.isPalindrome(input);
        boolean passed = output == true;
        System.out.println("testSolutionMemoryOptimized1: " + (passed ? "passed" : "failed"));
    }
}