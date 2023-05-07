package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionArraysPractice2 {

    public static void main(String[] args) {
        testSolutionArraysPractice2_1();
        testSolutionArraysPractice2_2();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int l = output.size();
            for (int j = 0; j < l; j++) {
                List<Integer> copy = new ArrayList<>(output.get(j));
                copy.add(nums[i]);
                output.add(copy);
            }
        }
        return output;
    }

    private static void testSolutionArraysPractice2_1() {
        int[] nums = {1,2,3};
        SolutionArraysPractice2 s = new SolutionArraysPractice2();
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
        System.out.println("testSolutionArraysPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionArraysPractice2_2() {
        int[] nums = {0};
        SolutionArraysPractice2 s = new SolutionArraysPractice2();
        List<List<Integer>> output = s.subsets(nums);
        boolean passed = output.size() == 8;
        for (int i = 0; i < output.size(); i++) {
            Integer[] o = output.get(i).toArray(new Integer[]{});
            passed = Arrays.deepEquals(o, new Integer[]{}) 
                || Arrays.deepEquals(o, new Integer[]{0});
        }
        System.out.println("testSolutionArraysPractice2_2: " + (passed ? "passed" : "failed"));
    }

}
