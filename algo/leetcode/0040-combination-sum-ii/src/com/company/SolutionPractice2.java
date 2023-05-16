package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionPractice2 {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        BT(0, candidates, target, new ArrayList<>(), 0, output);
        return output;
    }

    private void BT(int idx, int[] candidates, int target, List<Integer> acc, int currSum, List<List<Integer>> output) {
        if (currSum == target) {
            output.add(new ArrayList<>(acc));
            return;
        }
        if (currSum > target) {
            return;
        }

        for (int i = idx; i <  candidates.length; i++) {
            if (i == idx || candidates[i] != candidates[i-1]) {
                acc.add(candidates[i]);
                BT(i+1, candidates, target, acc, currSum + candidates[i], output);
                acc.remove(acc.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    private static void testSolutionPractice2_1() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Integer[][] expectedA = {{1,1,6},{1,2,5},{1,7},{2,6}};
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> outputL = s.combinationSum2(candidates, target);
        boolean passed = Util.lst2ToSet2.apply(outputL).equals(
            Util.lst2ToSet2.compose(Util.arr2ToLst2).apply(expectedA)
        );
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionPractice2_2() {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        Integer[][] expectedA = {{1,2,2},{5}};
        SolutionPractice2 s = new SolutionPractice2();
        List<List<Integer>> outputL = s.combinationSum2(candidates, target);
        boolean passed = Util.lst2ToSet2.apply(outputL).equals(
            Util.lst2ToSet2.compose(Util.arr2ToLst2).apply(expectedA)
        );
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }

}
