package com.company;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();

        testSolutionNaive1();
        testSolutionNaive2();
    }

    public static void test1() {
        int []nums1 = { 1, 3 };
        int []nums2 = { 2 };
        Solution solution = new Solution();
        boolean validated = solution.findMedianSortedArrays(nums1, nums2) == 2.0;
        System.out.println("test1 " + (validated ? "passed" : "failed"));
    }

    public static void test2() {
        int []nums1 = { 1, 2 };
        int []nums2 = { 3, 4 };
        Solution solution = new Solution();
        boolean validated = solution.findMedianSortedArrays(nums1, nums2) == 2.5;
        System.out.println("test2 " + (validated ? "passed" : "failed"));
    }

    public static void testSolutionNaive1() {
        int []nums1 = { 1, 3 };
        int []nums2 = { 2 };
        SolutionNaive solution = new SolutionNaive();
        boolean validated = solution.findMedianSortedArrays(nums1, nums2) == 2.0;
        System.out.println("testSolutionNaive1: " + (validated ? "passed" : "failed"));
    }

    public static void testSolutionNaive2() {
        int []nums1 = { 1, 2 };
        int []nums2 = { 3, 4 };
        SolutionNaive solution = new SolutionNaive();
        boolean validated = solution.findMedianSortedArrays(nums1, nums2) == 2.5;
        System.out.println("testSolutionNaive2: " + (validated ? "passed" : "failed"));
    }
}
