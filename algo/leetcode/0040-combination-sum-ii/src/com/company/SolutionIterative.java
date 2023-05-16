package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionIterative {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        List<List<Integer>> core = new ArrayList<>();
        core.add(new ArrayList<>());
        sum.add(0);
        List<Integer> prevAdded = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> toAdd = new ArrayList<>();
            for (int j = 0; j < core.size(); j++) {
                if (sum.get(j) + candidates[i] <= target) {
                    List l = new ArrayList<>(core.get(j));
                    l.add(candidates[i]);
                    Integer currSum = sum.get(j) + candidates[i];
                    if (currSum == target) {
                        output.add(l);
                        prevAdded = l;
                    } else {
                        if (core.size() == 0 || !isEqual(l, core.get(core.size() - 1))) {
                            toAdd.add(l);
                            sum.add(currSum);
                        }
                    }
                }
            }
            core.addAll(toAdd);
        }
        return output;
    }

    private boolean isEqual(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }

        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
