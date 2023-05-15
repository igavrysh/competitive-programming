package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPractice22 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        BT(0, new ArrayList<>(), output, nums);
        return output;
    }

    private void BT(int idx, List<Integer> acc, List<List<Integer>> output, int[] nums) {
        output.add(new ArrayList<>(acc));
        if (idx >= nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i == idx || nums[i] != nums[i-1]) {
                acc.add(nums[i]);
                BT(i+1, acc, output, nums);
                acc.remove(acc.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        testSolutionPractice22_3();
        testSolutionPractice22_1();
        testSolutionPractice22_2();
    }

    public static void testSolutionPractice22_1() {
        int[] nums = {1,2,2};
        SolutionPractice22 s = new SolutionPractice22();
        List<List<Integer>> output = s.subsetsWithDup(nums);
        int t = 1;
    }

    public static void testSolutionPractice22_2() {
        int[] nums = {1,2};
        SolutionPractice22 s = new SolutionPractice22();
        List<List<Integer>> output = s.subsetsWithDup(nums);
        int t = 1;
    }

    public static void testSolutionPractice22_3() {
        int[] nums = {1,1,2,2};
        SolutionPractice22 s = new SolutionPractice22();
        List<List<Integer>> output = s.subsetsWithDup(nums);
        int t = 1;
    }

}
