package com.company;

public class Main {
    public static void test1() {
        Solution s = new Solution();
        int[] output = s.searchRange(new int[] {5,7,7,8,8,10}, 8);
        boolean passed = output[0] == 3 && output[1] == 4;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        Solution s = new Solution();
        int[] output = s.searchRange(new int[] {5,7,7,8,8,10}, 6);
        boolean passed = output[0] == -1 && output[1] == -1;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        Solution s = new Solution();
        int[] output = s.searchRange(new int[] {}, 6);
        boolean passed = output[0] == -1 && output[1] == -1;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
