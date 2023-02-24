package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
        testSolution4();
    }

    public static void testSolution1() {
        Solution s = new Solution();
        int output = s.minimumDeviation(new int[]{1,2,3,4});
        boolean passed = output == 1;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        Solution s = new Solution();
        int output = s.minimumDeviation(new int[]{4,1,5,20,3});
        boolean passed = output == 3;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        Solution s = new Solution();
        int output = s.minimumDeviation(new int[]{2,10,8});
        boolean passed = output == 3;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4() {
        Solution s = new Solution();
        int output = s.minimumDeviation(new int[]{3,5});
        boolean passed = output == 1;
        System.out.println("testSolution4: " + (passed ? "passed" : "failed"));
    }
}