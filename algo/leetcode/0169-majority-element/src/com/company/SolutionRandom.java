package com.company;

import java.util.HashMap;
import java.util.Random;

public class SolutionRandom {
    public int majorityElement(int[] nums) {
        int N = nums.length;
        if (N>=1 && N<=2) {
            return nums[0];
        }
        Random rand = new Random();
        HashMap<Integer, Integer> fq = new HashMap<>();
        int cnt = (int)(N * 0.75);
        int k = 0;
        int maxFq = 0;
        int maxVal = -1;
        while (k < cnt) {
            int i = rand.nextInt(N);
            int newFq = fq.getOrDefault(nums[i], 0)+1;
            fq.put(nums[i], newFq);
            if (newFq > maxFq) {
                maxFq = newFq;
                maxVal = nums[i];
            }
            k++;
        }
        return maxVal;
    }
}
