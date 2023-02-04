package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
    }

    public static void testSolution1() {
        String[] tokens = new String[]{"2","1","+","3","*"};
        Solution s = new Solution();
        int output = s.evalRPN(tokens);
        boolean passed = output == 9;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        String[] tokens = new String[]{"4","13","5","/","+"};
        Solution s = new Solution();
        int output = s.evalRPN(tokens);
        boolean passed = output == 6;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Solution s = new Solution();
        int output = s.evalRPN(tokens);
        boolean passed = output == 22;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }
}