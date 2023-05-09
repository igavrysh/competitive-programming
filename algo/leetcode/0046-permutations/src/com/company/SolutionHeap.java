package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionHeap {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        generate(nums.length, nums, output);;

        return output;
    }

    private void generate(int k, int[] A, List<List<Integer>> output) {
        if (k == 1) {
            List<Integer> o = new ArrayList<>(A.length);
            for (int i = 0; i < A.length; i++) {
                o.add(A[i]);
            }
            output.add(o);
            return;
        }

        generate(k-1, A, output);

        for (int i = 0; i < k-1; i++) {
            if (k%2 == 0) {
                swap(A, i, k-1);
            } else {
                swap(A, 0, k-1);
            }
            generate(k-1, A, output);
        }
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
    
}
