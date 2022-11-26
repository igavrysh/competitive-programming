package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        int N = (int) Math.pow(2, n);
        int[] a = new int[N];
        a[0] = 0; 
        a[1] = 1;
        int k = 1;
        for (int i = 2; i < N; i++) {
            a[i] = (1 << (int)(Math.log(i) / Math.log(2))) | a[k--];
            if (k == -1) {
                k = i;
            }
        }

        List<Integer> result = new ArrayList<>(a.length);
        for (int i : a) {
            result.add(i);
        }
        return result;
    }
}
