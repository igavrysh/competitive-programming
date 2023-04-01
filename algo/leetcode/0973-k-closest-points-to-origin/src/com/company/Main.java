package com.company;

import java.util.Arrays;

public class Main {

    public static void test1() {
        int[][] input = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        Solution s = new Solution();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 1 && Arrays.equals(output[0], new int[] { -2, 2 });
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[][] input = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        Solution s = new Solution();
        int[][] output = s.kClosest(input, k);
        boolean passed = output.length == 2 && Arrays.deepEquals(output, new int[][] { { 3, 3 }, { -2, 4 } });
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
