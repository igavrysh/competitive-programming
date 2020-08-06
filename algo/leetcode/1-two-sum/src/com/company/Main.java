package com.company;

import java.util.Arrays;

public class Main {

    public static void test1() {
        Solution solution = new Solution();
        int[] output = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        boolean checked = Arrays.equals(output, new int[]{0, 1});
        System.out.println(checked ? "test1 passed" : "test1 failed");
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] output = solution.twoSum(new int[]{2, 7, 11, 15}, 17);
        boolean checked = Arrays.equals(output, new int[]{0, 3});
        System.out.println(checked ? "test2 passed" : "test2 failed");
    }

    public static void test3() {
        Solution solution = new Solution();
        int[] output = solution.twoSum(new int[]{2, 7, 11, 15}, 13);
        boolean checked = Arrays.equals(output, new int[]{0, 2});
        System.out.println(checked ? "test3 passed" : "test3 failed");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
