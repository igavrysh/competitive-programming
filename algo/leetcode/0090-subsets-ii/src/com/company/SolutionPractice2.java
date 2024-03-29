package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Util.lst2ToSet2;
import static com.company.Util.arr2ToLst2;

public class SolutionPractice2 {
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
        testSolutionPractice2_1();
        testSolutionPractice2_2();
        testSolutionPractice2_3();
    }

    public static void testSolutionPractice2_1() {
        int[] nums = {1,2,2};
        Integer[][] expectedArray = {{},{1},{2},{2,2},{1,2},{1,2,2}};    
        
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.subsetsWithDup(nums);

        boolean passed = lst2ToSet2.apply(arr2ToLst2.apply(expectedArray))
            .equals(
                lst2ToSet2.apply(output)
            );

        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        int[] nums = {1,2};
        Integer[][] expectedArray = {{},{1},{2},{1,2}};

        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.subsetsWithDup(nums);

        boolean passed = lst2ToSet2.apply(arr2ToLst2.apply(expectedArray))
            .equals(
                lst2ToSet2.apply(output)
            );

        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_3() {
        int[] nums = {1,1,2,2};
        Integer[][] expectedArray = {{},{1},{2},{1,1},{1,2},{2,2},{1,1,2},{2,2,1},{1,1,2,2}};

        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> output = s.subsetsWithDup(nums);

        boolean passed = lst2ToSet2.apply(arr2ToLst2.apply(expectedArray))
            .equals(
                lst2ToSet2.apply(output)
            );

        System.out.println("testSolutionPractice2_3: " + (passed ? "passed" : "failed"));
    }

}
