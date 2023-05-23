package com.company;

public class Main {
    public static void test1() {
        Solution s = new Solution();
        int output = s.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
        boolean passed = output == 4;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int output = s.lengthOfLIS(new int[] {});
        boolean passed = output == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        int output = s.lengthOfLIS(new int[] { 5 });
        boolean passed = output == 1;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
