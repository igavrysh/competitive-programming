package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionArrayPractice2 {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        BT(0, nums, new ArrayList<>(), output);
        return output;
    }

    private void BT(int idx, int[] nums, List<Integer> acc, List<List<Integer>> output) {
        if (idx >= nums.length) {
            output.add(new ArrayList<>(acc));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            acc.add(nums[i]);

            int tmp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = tmp;
            
            BT(idx+1, nums, acc, output);
            nums[i] = nums[idx];
            nums[idx] = tmp;
            acc.remove(acc.size()-1);
        }
    }

    public static void main(String[] args) {
        testSolutionArrayPractice2_1();
        testSolutionArrayPractice2_2();
        testSolutionArrayPractice2_3();
    }

    public static void testSolutionArrayPractice2_1() {
        SolutionArrayPractice2 solution = new SolutionArrayPractice2();
        List<List<Integer>> output = solution.permute(new int[] { 1, 2, 3 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1, 2, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 3, 2 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 3, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 2, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 1, 2 }));
        System.out.println("testSolutionArrayPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionArrayPractice2_2() {
        SolutionArrayPractice2 solution = new SolutionArrayPractice2();
        List<List<Integer>> output = solution.permute(new int[] { 0, 1 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 0, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 0 }));
        System.out.println("testSolutionArrayPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionArrayPractice2_3() {
        SolutionArrayPractice2 solution = new SolutionArrayPractice2();
        List<List<Integer>> output = solution.permute(new int[] { 1 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1 }));
        System.out.println("testSolutionArrayPractice2_3:" + (passed ? "passed" : "failed"));
    }

}
