package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
    }

    public static void testSolution1() {
        Solution s = new Solution();
        int[] weights = new int[] {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int output = s.shipWithinDays(weights, days);
        boolean passed = output == 15;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        Solution s = new Solution();
        int[] weights = new int[] {3,2,2,4,1,4};
        int days = 3;
        int output = s.shipWithinDays(weights, days);
        boolean passed = output == 6;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        Solution s = new Solution();
        int[] weights = new int[] {1,2,3,1,1};
        int days = 4;
        int output = s.shipWithinDays(weights, days);
        boolean passed = output == 3;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

}