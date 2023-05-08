package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOptimized {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        combinationSumInternal(candidates, target, 0, new ArrayList<>(), output);
        return output;
    }

    public void combinationSumInternal(int[] candidates, int target, int startIndex, List<Integer> acc, List<List<Integer>> output) {
        if (target == 0) {
            output.add(new ArrayList<>(acc));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            acc.add(candidates[i]);
            combinationSumInternal(candidates, target - candidates[i], i, acc, output);
            acc.remove(acc.size() - 1);
        }
    }
}
