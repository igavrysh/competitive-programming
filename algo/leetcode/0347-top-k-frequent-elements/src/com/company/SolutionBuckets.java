package com.company;

import java.util.ArrayList;
import java.util.List;

public class SolutionBuckets {

    public int[] topKFrequent(int[] nums, int k) {
        // record min max for creating "compressed histogram"
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } 
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        // index of fq = num from nums - min
        // value of fq = number of occurences of num from nums
        int[] fq = new int[max-min+1];
        int maxFq = 0;
        int distinctNums = 0;
        for (int i = 0; i < nums.length; i++) {
            fq[nums[i]-min]++;
            if (fq[nums[i]-min] == 1) { distinctNums++; }
            maxFq = Math.max(fq[nums[i]-min], maxFq);
        }

        if (k > distinctNums) {
            return null;
        }

        // bucket, index = frequency, value = list of nums with frequency = index-1
        // 0 frequencies are excluded
        // under index = 0 stored list of nums with frequency of 1
        // ...
        // under index = m stored list of nums with frequence of m+1 
        List<Integer>[] buckets = new List[maxFq];
        for (int i = 0; i < fq.length; i++) {
            if (fq[i] == 0) {
                continue;
            }

            List<Integer> bucket = buckets[fq[i]-1] ;
            if (buckets[fq[i]-1] == null) {
                bucket = new ArrayList<>();
                buckets[fq[i]-1] = bucket;
            }
            bucket.add(min+i);
        }

        int[] output = new int[k];
        int outputI = 0;
        // go from the end for frequncies, starting from biggest frequency, 
        // collect nums with highest frequency into output array, 
        // use outputI as a counter, interate until k is reached
        for (int i = buckets.length-1; i >= 0; i--) {
            if (outputI == k) {
                break;
            }
            if (buckets[i] != null) {
                while (buckets[i].size() > 0 && outputI < k) {
                    output[outputI++] = buckets[i].remove(buckets[i].size()-1);
                }
            }
        }
        return output;
    }
}
