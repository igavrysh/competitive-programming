package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.company.Util.lst2ToSet2;
import static com.company.Util.arr2ToLst2;

public class SolutionPractice2CountingSort {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        countSort(nums);
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

    private void countSort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        int[] fq = new int[max-min+1];
        for (int i = 0; i < nums.length; i++) {
            fq[nums[i]-min]++;
        }

        int idx = 0;
        for (int i = 0; i < fq.length; i++) {
            while (fq[i] > 0) {
                fq[i]--;
                nums[idx] = i+min;
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        testSolutionPractice2CountingSort_1();
        testSolutionPractice2CountingSort_2();
        testSolutionPractice2CountingSort_3();
    }

    public static void testSolutionPractice2CountingSort_1() {
        int[] nums = {1,2,2};
        Integer[][] expectedArray = {{},{1},{2},{2,2},{1,2},{1,2,2}};    
        
        SolutionPractice2CountingSort s = new SolutionPractice2CountingSort();
        List<List<Integer>> output = s.subsetsWithDup(nums);

        boolean passed = lst2ToSet2.apply(arr2ToLst2.apply(expectedArray))
            .equals(
                lst2ToSet2.apply(output)
            );

        System.out.println("testSolutionPractice2CountingSort_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2CountingSort_2() {
        int[] nums = {1,2};
        Integer[][] expectedArray = {{},{1},{2},{1,2}};

        SolutionPractice2CountingSort s = new SolutionPractice2CountingSort();
        List<List<Integer>> output = s.subsetsWithDup(nums);

        boolean passed = lst2ToSet2.apply(arr2ToLst2.apply(expectedArray))
            .equals(
                lst2ToSet2.apply(output)
            );

        System.out.println("testSolutionPractice2CountingSort_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2CountingSort_3() {
        int[] nums = {1,1,2,2};
        Integer[][] expectedArray = {{},{1},{2},{1,1},{1,2},{2,2},{1,1,2},{2,2,1},{1,1,2,2}};

        SolutionPractice2CountingSort s = new SolutionPractice2CountingSort();
        List<List<Integer>> output = s.subsetsWithDup(nums);

        boolean passed = lst2ToSet2.apply(arr2ToLst2.apply(expectedArray))
            .equals(
                lst2ToSet2.apply(output)
            );

        System.out.println("testSolutionPractice2CountingSort_3: " + (passed ? "passed" : "failed"));
    }
}
