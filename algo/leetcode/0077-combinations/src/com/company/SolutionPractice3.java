package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice3 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        int[] curr = new int[k];
        for (int lowBound = 1; lowBound <= n-k; lowBound++) {
            for (int idx = 0; idx < k; idx++) {
                for (int i = lowBound; i <= n; i++) {
                    curr[idx] = i;
                    if (idx==k-1) {
                        List<Integer> o = new ArrayList<>();
                        for (int j = 0; j < curr.length; j++) {
                            o.add(curr[j]);
                        }
                        output.add(o);
                    }
                }
            }
        }
        return output;
    }
}
