package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionRecursiveBTPractice2 {
    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        BT(0, nums, new ArrayList<>(), output);
        return output;
    }

    private void BT(int idx, int[] nums, List<Integer> acc, List<List<Integer>> output) {
        if (idx >= nums.length) {
            output.add(new ArrayList<Integer>(acc));
            return;
        }

        BT(idx+1, nums, acc, output);
        acc.add(nums[idx]);
        BT(idx+1, nums,  acc, output);
        acc.remove(acc.size()-1);
    }

    private static void testSolutionPractice2_1() {
        int[] nums = {1,2,3};
        SolutionRecursiveBTPractice2 s = new SolutionRecursiveBTPractice2();
        List<List<Integer>> output = s.subsets(nums);
        boolean passed = output.size() == 8;
        for (int i = 0; i < output.size(); i++) {
            Integer[] o = output.get(i).toArray(new Integer[]{});
            passed = Arrays.deepEquals(o, new Integer[]{}) 
                || Arrays.deepEquals(o, new Integer[]{1}) 
                || Arrays.deepEquals(o, new Integer[]{2}) 
                || Arrays.deepEquals(o, new Integer[]{3}) 
                || Arrays.deepEquals(o, new Integer[]{1,2}) 
                || Arrays.deepEquals(o, new Integer[]{1,3}) 
                || Arrays.deepEquals(o, new Integer[]{1,2,3}) 
                || Arrays.deepEquals(o, new Integer[]{2,3});
        }
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        int[] nums = {0};
        SolutionRecursiveBTPractice2 s = new SolutionRecursiveBTPractice2();
        List<List<Integer>> output = s.subsets(nums);
        boolean passed = output.size() == 8;
        for (int i = 0; i < output.size(); i++) {
            Integer[] o = output.get(i).toArray(new Integer[]{});
            passed = Arrays.deepEquals(o, new Integer[]{}) 
                || Arrays.deepEquals(o, new Integer[]{0});
        }
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }
}