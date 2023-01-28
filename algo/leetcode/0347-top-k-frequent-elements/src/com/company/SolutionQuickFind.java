package com.company;

import java.util.HashMap;
import java.util.Map;

class SolutionQuickFind {
    public int[] topKFrequent(int[] inputNums, int k) {
        if (k > inputNums.length) {
            return null;
        }
        
        HashMap<Integer, Integer> M = new HashMap<>();
        for (int num : inputNums) {
            M.put(num, M.getOrDefault(num, 0)+1);
        }
        int[] nums = new int[M.size()];
        int[] fq = new int[M.size()];
        int j = 0;
        for (Map.Entry<Integer, Integer> e : M.entrySet()) {
            nums[j] = e.getKey();
            fq[j] = e.getValue();
            j++;
        }

        if (k == inputNums.length) {
            return nums;
        }

        kThFqIndex(0, nums.length-1, k, nums, fq);

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = nums[nums.length-1-i];
        }

        return output;
    }

    private void kThFqIndex(int s, int e, int k, int[] nums, int[] fq) {
        if (s==e) { return; }
        swap(s, e, nums, fq);
        int i = s;
        for (int j = s; j < e; j++) {
            if (fq[j] > fq[e]) { // keep bigger elements in end
                continue; 
            } else {
                swap(i, j, nums, fq);
                i++;
            }
        }
        swap(i, e, nums, fq);

        if (e-i+1 == k) { return; }
        
        if (e-i+1 < k) { kThFqIndex(s, i-1, k-(e-i+1), nums, fq); } 
        else { kThFqIndex(i+1, e, k, nums, fq); }
    }

    private void swap(int i, int j, int[]nums, int[] fq) {
        if (i==j) { return; }
        int tmpfq = fq[i];
        int tmpnum = nums[i];
        fq[i] = fq[j];
        nums[i] = nums[j];
        fq[j] = tmpfq;
        nums[j] = tmpnum;
    }
}