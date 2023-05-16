package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionOptimizedX3 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        countingSort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        comb(candidates, target, 0, 0, new ArrayList<>(), output, target);
        return output;
    }

    private void countingSort(int[] a) {
        int min = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        // should be changed to int[] fq with counter of "i+min" values in a[]
        // to account for non unique values in candidates
        boolean[] present = new boolean[max-min+1];
        for (int i = 0; i < a.length; i++) {
            present[a[i]-min] = true;
        }
        int idx = 0;
        for (int i = 0; i <= present.length; i++) {
            // should be chnaged to fq[i]>0, and fq[i]--
            // to account for non unique values in a[]
            if (present[i]) {
                a[idx++] = i+min;
            }
        }
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
