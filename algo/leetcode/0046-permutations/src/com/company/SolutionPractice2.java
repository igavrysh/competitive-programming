package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPractice2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> numsA = new ArrayList<>();
        for (int num : nums) {
            numsA.add(num);
        }
        BT(numsA, new ArrayList<>(), output);
        return output;
    }

    private void BT(ArrayList<Integer> nums, List<Integer> acc, List<List<Integer>> output) {
        if (nums.size() == 0) {
            output.add(new ArrayList<>(acc));
        }

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            acc.add(val);
            nums.remove(i);
            BT(nums, acc, output);
            acc.remove(acc.size()-1);
            nums.add(i, val);
        }
    }

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
    }

    public static void testSolutionPractice2_1() {
        SolutionPractice2 solution = new SolutionPractice2();
        List<List<Integer>> output = solution.permute(new int[] { 1, 2, 3 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1, 2, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 3, 2 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 1, 3 }))
                && output.contains(Arrays.asList(new Integer[] { 2, 3, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 2, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 3, 1, 2 }));
        System.out.println("testSolutionPractice2_1:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        SolutionPractice2 solution = new SolutionPractice2();
        List<List<Integer>> output = solution.permute(new int[] { 0, 1 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 0, 1 }))
                && output.contains(Arrays.asList(new Integer[] { 1, 0 }));
        System.out.println("testSolutionPractice2_2:" + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        SolutionPractice2 solution = new SolutionPractice2();
        List<List<Integer>> output = solution.permute(new int[] { 1 });
        boolean passed = output.contains(Arrays.asList(new Integer[] { 1 }));
        System.out.println("testSolutionPractice2_3:" + (passed ? "passed" : "failed"));
    }
}
