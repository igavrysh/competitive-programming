package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionPractice2 {

    public static void main(String[] args) {
        testSolutionPractice2_1();
        testSolutionPractice2_2();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        BT(0, new ArrayList<Integer>(), 0, output, candidates, target);
        return output;
    }

    private void  BT(int idx, List<Integer> acc, int currTrgt, List<List<Integer>> output, int [] candidates, int target) {
        if (currTrgt == target) {
            output.add(new ArrayList<Integer>(acc));
            return;
        }
        if (currTrgt > target || idx >= candidates.length) {
            return;
        }

        acc.add(candidates[idx]);
        BT(idx, acc, currTrgt+candidates[idx], output, candidates, target);
        acc.remove(acc.size()-1);
        BT(idx+1, acc, currTrgt, output, candidates, target);
    }

    public static void testSolutionPractice2_1() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        SolutionPractice2 solution = new SolutionPractice2();
        List<List<Integer>> output = solution.combinationSum(candidates, target);
        boolean passed = output.size() == 2;
        for (int i = 0; i < output.size(); i++) {
            Integer[] o = output.get(i).toArray(new Integer[]{});
            Arrays.sort(o);
            passed =  passed && (Arrays.deepEquals(o, new Integer[]{2,2,3}) 
                || Arrays.deepEquals(o, new Integer[]{7}));
        }
        System.out.println("testSolutionPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionPractice2_2() {
        int[] candidates = {2,3,5};
        int target = 8;
        SolutionPractice2 solution = new SolutionPractice2();
        List<List<Integer>> output = solution.combinationSum(candidates, target);
        boolean passed = output.size() == 3;
        for (int i = 0; i < output.size(); i++) {
            Integer[] o = output.get(i).toArray(new Integer[]{});
            Arrays.sort(o);
            passed = passed && ( Arrays.deepEquals(o, new Integer[]{2,2,2,2}) 
                || Arrays.deepEquals(o, new Integer[]{2,3,3})
                || Arrays.deepEquals(o, new Integer[]{3,5})
            );
        }
        System.out.println("testSolutionPractice2_2: " + (passed ? "passed" : "failed"));
    }
}