package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionFq2Practice2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] fq = new int[31];
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= 30) {
                fq[candidates[i]]++;
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        BT(0, fq, target, new ArrayList<>(), output);
        return output;
    }

    private void BT(int idx, int[] fq, int target, List<Integer> acc, List<List<Integer>> output) {
        if (target == 0) {
            output.add(new ArrayList<>(acc));
            return;
        }

        if (target < 0 || idx > target) {
            return;
        }

        if (fq[idx] > 0) {
            int num = idx;
            fq[idx]--;
            acc.add(num);
            BT(idx, fq, target-num, acc, output);
            acc.remove(acc.size()-1);
            fq[idx]++;
        }

        BT(idx+1, fq, target, acc, output);
    }

    public static void main(String[] args) {
        testSolutionFq2Practice2_1();
        testSolutionFq2Practice2_2();
    }

    private static void testSolutionFq2Practice2_1() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Integer[][] expectedA = {{1,1,6},{1,2,5},{1,7},{2,6}};
        SolutionFq2Practice2 s = new SolutionFq2Practice2();
        List<List<Integer>> outputL = s.combinationSum2(candidates, target);
        boolean passed = Util.lst2ToSet2.apply(outputL).equals(
            Util.lst2ToSet2.compose(Util.arr2ToLst2).apply(expectedA)
        );
        System.out.println("testSolutionFq2Practice2_1: " + (passed ? "passed" : "failed"));
    }

    private static void testSolutionFq2Practice2_2() {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        Integer[][] expectedA = {{1,2,2},{5}};
        SolutionFq2Practice2 s = new SolutionFq2Practice2();
        List<List<Integer>> outputL = s.combinationSum2(candidates, target);
        boolean passed = Util.lst2ToSet2.apply(outputL).equals(
            Util.lst2ToSet2.compose(Util.arr2ToLst2).apply(expectedA)
        );
        System.out.println("testSolutionFq2Practice2_2: " + (passed ? "passed" : "failed"));
    }
}
