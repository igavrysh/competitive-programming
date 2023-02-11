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

        testSolutionTwoPointersBinarySearch1();
        testSolutionTwoPointersBinarySearch2();
        
        testSolutionTwoPointersBS2_1();
    }

    public static void testSolutionTwoPointersBS2_1() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        SolutionTwoPointersBS2 s = new SolutionTwoPointersBS2();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionTwoPointersBS2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointersBinarySearch1() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        SolutionTwoPointersBinarySearch s = new SolutionTwoPointersBinarySearch();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionTwoPointersBinarySearch1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionTwoPointersBinarySearch2() {
        int[] nums = new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
        int target = 542;
        SolutionTwoPointersBinarySearch s = new SolutionTwoPointersBinarySearch();
        int[] output = s.twoSum(nums, target);
        boolean passed = Arrays.equals(output, new int[]{24,32});
        System.out.println("testSolutionTwoPointersBinarySearch2: " + (passed ? "passed" : "failed"));
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