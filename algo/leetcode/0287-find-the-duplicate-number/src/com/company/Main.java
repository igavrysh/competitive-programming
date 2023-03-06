package com.company;

public class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
    }

    private static void testSolution1() {
        int[] nums = new int[]{1,3,4,2,2};
        Solution s = new Solution();
        int output = s.findDuplicate(nums);
        boolean passed = output == 2;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolution2() {
        int[] nums = new int[]{3,1,3,4,2};
        Solution s = new Solution();
        int output = s.findDuplicate(nums);
        boolean passed = output == 3;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    private static void testSolution3() {
        int[] nums = new int[]{1,1};
        Solution s = new Solution();
        int output = s.findDuplicate(nums);
        boolean passed = output == 1;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }
}
