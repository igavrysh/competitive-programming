package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(0, n, k, new ArrayList<>(), output);
        return output;
    }

    private void backtrack(int s, int n, int k, List<Integer> acc, List<List<Integer>> output) {
        if (acc.size() == k) {
            output.add(new ArrayList<>(acc));
        }
        if (s >= n) {
            return;
        }
        for (int i = s; i < n; i++) {
            acc.add(i + 1);
            backtrack(i + 1, n, k, acc, output);
            acc.remove(acc.size() - 1);
        }
    }
}
