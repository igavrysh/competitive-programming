package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice2 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        BT(n, k, 0, 1, new int[k], output);
        return output;
    }

    public void BT(int n, int k, int idx, int lowBound, int[] curr, List<List<Integer>> output) {
        for (int i = lowBound; i <= n; i++) {
            curr[idx] = i;
            if (idx==k-1) {
                List<Integer> o = new ArrayList<>();
                for (int j = 0; j < curr.length; j++) {
                    o.add(curr[j]);
                }
                output.add(o);
            } else {
                BT(n, k, idx+1, i+1, curr, output);
            }
        }
    }
}
