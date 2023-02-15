package com.company;

class Main {
    public static void main(String[] args) {
        testSolution1();
        testSolution2();
        testSolution3();
        testSolution4();
    }

    public static void testSolution1() {
        int[] nums = new int[]{3,4,5,1,2};
        Solution s = new Solution();
        int output = s.findMin(nums);
        boolean passed = output == 1;
        System.out.println("testSolution1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        Solution s = new Solution();
        int output = s.findMin(nums);
        boolean passed = output == 0;
        System.out.println("testSolution2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution3() {
        int[] nums = new int[]{11,13,15,17};
        Solution s = new Solution();
        int output = s.findMin(nums);
        boolean passed = output == 11;
        System.out.println("testSolution3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution4() {
        int[] nums = new int[]{3,1,2};
        Solution s = new Solution();
        int output = s.findMin(nums);
        boolean passed = output == 1;
        System.out.println("testSolution4: " + (passed ? "passed" : "failed"));
    }
}