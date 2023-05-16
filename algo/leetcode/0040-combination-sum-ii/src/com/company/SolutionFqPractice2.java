package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionFqPractice2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] fq = new int[31];
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= 30)
            fq[candidates[i]]++;
        }

        List<List<Integer>> output = new ArrayList<>();
        BT(0, fq, target, new ArrayList<>(), 0, output);
        return output;
    }

    private void BT(int idx, int[] fq, int target, List<Integer> acc, int accSum, List<List<Integer>> output) {
        if (accSum > target) {
            return;
        }

        if (target == accSum) {
            output.add(new ArrayList<>(acc));
            return;
        }

        if (idx >= fq.length) {
            return;
        }

        if (fq[idx] > 0) {
            int num = idx;
            fq[idx]--;
            acc.add(num);
            BT(idx, fq, target, acc, accSum + num, output);
            acc.remove(acc.size()-1);
            fq[idx]++;
        }

        BT(idx+1, fq, target, acc, accSum, output);
    }

    public static void main(String[] args) {
        testSolutionFqPractice2_1();
        testSolutionFqPractice2_2();
    }

    private static void testSolutionFqPractice2_1() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Integer[][] expectedA = {{1,1,6},{1,2,5},{1,7},{2,6}};
        SolutionFqPractice2 s = new SolutionFqPractice2();
        List<List<Integer>> outputL = s.combinationSum2(candidates, target);
        boolean passed = Util.lst2ToSet2.apply(outputL).equals(
            Util.lst2ToSet2.compose(Util.arr2ToLst2).apply(expectedA)
        );
        System.out.println("testSolutionFqPractice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionFqPractice2_2() {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        Integer[][] expectedA = {{1,2,2},{5}};
        SolutionFqPractice2 s = new SolutionFqPractice2();
        List<List<Integer>> outputL = s.combinationSum2(candidates, target);
        boolean passed = Util.lst2ToSet2.apply(outputL).equals(
            Util.lst2ToSet2.compose(Util.arr2ToLst2).apply(expectedA)
        );
        System.out.println("testSolutionFqPractice2_2: " + (passed ? "passed" : "failed"));
    }
    
}
