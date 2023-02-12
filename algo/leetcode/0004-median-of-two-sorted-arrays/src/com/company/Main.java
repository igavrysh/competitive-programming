package com.company;

public class Main {

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


    public static void main(String[] args) {
        test1();
        test2();
    }
}
