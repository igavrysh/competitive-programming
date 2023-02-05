package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
    }

    public static void testSolution1() {
        int target = 12;
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};
        Solution s = new Solution();
        int output = s.carFleet(target, position, speed);
        boolean passed = output == 3;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        int target = 10;
        int[] position = new int[]{3};
        int[] speed = new int[]{3};
        Solution s = new Solution();
        int output = s.carFleet(target, position, speed);
        boolean passed = output == 1;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        int target = 100;
        int[] position = new int[]{0,2,4};
        int[] speed = new int[]{4,2,1};
        Solution s = new Solution();
        int output = s.carFleet(target, position, speed);
        boolean passed = output == 1;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }
}