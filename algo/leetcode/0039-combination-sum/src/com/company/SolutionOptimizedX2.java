package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOptimizedX2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        comb(candidates, target, 0, 0, new ArrayList<>(), output, target);
        return output;
    }

    private void comb(int[] candidates, int trg, int startIndex, int accSum, List<Integer> acc,
            List<List<Integer>> output, int initTrg) {
        if (trg == 0) {
            output.add(new ArrayList<>(acc));
            return;
        }

        if (trg < 0 || trg < candidates[startIndex] || accSum >= initTrg) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            acc.add(candidates[i]);
            comb(candidates, trg - candidates[i], i, accSum + candidates[i], acc, output, initTrg);
            acc.remove(acc.size() - 1);
        }
    }
}
