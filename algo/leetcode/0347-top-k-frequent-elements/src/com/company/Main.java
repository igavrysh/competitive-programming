package com.company;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        testSolutionQuickFind1();
        testSolutionQuickFind2();
    }

    public static void testSolutionQuickFind1() {
        int[] nums = new int[]{1,1,1,2,2,3};
        SolutionQuickFind s = new SolutionQuickFind();
        int[] output = s.topKFrequent(nums, 2);
        boolean passed = Arrays.equals(output, new int[]{1,2}) || Arrays.equals(output, new int[]{2,1});
        System.out.println("testSolutionQuickFind1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionQuickFind2() {
        int[] nums = new int[]{1};
        SolutionQuickFind s = new SolutionQuickFind();
        int[] output = s.topKFrequent(nums, 1);
        boolean passed = Arrays.equals(output, new int[]{1}) || Arrays.equals(output, new int[]{1});
        System.out.println("testSolutionQuickFind2: " + (passed ? "passed" : "failed"));
    }
}