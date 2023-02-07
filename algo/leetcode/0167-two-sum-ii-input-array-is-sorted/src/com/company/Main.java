package com.company;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        testSolutionTwoPointers1();
        testSolutionTwoPointers2();
        testSolutionTwoPointers3();

        testSolutionTwoLoops1();
        testSolutionTwoLoops2();
        testSolutionTwoLoops3();
    }

    public static void testSolutionTwoPointers1() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        SolutionTwoPointers s = new SolutionTwoPointers();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionTwoPointers1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers2() {
        int[] nums = new int[]{2,3,4};
        int target = 6;
        SolutionTwoPointers s = new SolutionTwoPointers();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,3}) || Arrays.equals(output, new int[]{3,1});
        System.out.println("testSolutionTwoPointers2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointers3() {
        int[] nums = new int[]{-1,0};
        int target = -1;
        SolutionTwoPointers s = new SolutionTwoPointers();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionTwoPointers3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoLoops1() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        SolutionTwoLoops s = new SolutionTwoLoops();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionTwoLoops1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoLoops2() {
        int[] nums = new int[]{2,3,4};
        int target = 6;
        SolutionTwoLoops s = new SolutionTwoLoops();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,3}) || Arrays.equals(output, new int[]{3,1});
        System.out.println("testSolutionTwoLoops2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoLoops3() {
        int[] nums = new int[]{-1,0};
        int target = -1;
        SolutionTwoLoops s = new SolutionTwoLoops();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionTwoLoops3: " + (passed ? "passed" : "failed"));
    }
}