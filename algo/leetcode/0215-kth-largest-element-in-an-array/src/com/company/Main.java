package com.company;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();

        testMinHeap1();
        testMinHeap2();

        testQuickSelect1();
        testQuickSelect2();
        testQuickSelect3();
        testQuickSelect4();
    }

    public static void test1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Solution s = new Solution();
        int output = s.findKthLargest(nums, 2);
        boolean passed = output == 5;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        Solution s = new Solution();
        int output = s.findKthLargest(nums, 4);
        boolean passed = output == 4;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void testMinHeap1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        SolutionMinHeap s = new SolutionMinHeap();
        int output = s.findKthLargest(nums, 2);
        boolean passed = output == 5;
        System.out.println("testMinHeap1: " + (passed ? "passed" : "failed"));
    }

    public static void testMinHeap2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        SolutionMinHeap s = new SolutionMinHeap();
        int output = s.findKthLargest(nums, 4);
        boolean passed = output == 4;
        System.out.println("testMinHeap2: " + (passed ? "passed" : "failed"));
    }

    public static void testQuickSelect1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        SolutionQuickSelect s = new SolutionQuickSelect();
        int output = s.findKthLargest(nums, 2);
        boolean passed = output == 5;
        System.out.println("testQuickSelect1: " + (passed ? "passed" : "failed"));
    }

    public static void testQuickSelect2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        SolutionQuickSelect s = new SolutionQuickSelect();
        int output = s.findKthLargest(nums, 4);
        boolean passed = output == 4;
        System.out.println("testQuickSelect2: " + (passed ? "passed" : "failed"));
    }

    public static void testQuickSelect3() {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        SolutionQuickSelect s = new SolutionQuickSelect();
        int output = s.findKthLargest(nums, 2);
        boolean passed = output == 6;
        System.out.println("testQuickSelect3: " + (passed ? "passed" : "failed"));
    }

    public static void testQuickSelect4() {
        int[] nums = {1};
        SolutionQuickSelect s = new SolutionQuickSelect();
        int output = s.findKthLargest(nums, 1);
        boolean passed = output == 1;
        System.out.println("testQuickSelect4: " + (passed ? "passed" : "failed"));
    }
}
