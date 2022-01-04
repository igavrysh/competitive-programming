package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int s = 0; s < S.length(); s++) {
            int idx = S.charAt(s) - 'a';
            if (last[idx] == 0) {
                for (int e = S.length() - 1; e >= 0; e--) {
                    int idx2 = S.charAt(e) - 'a';
                    if (idx == idx2 && last[idx] < e) {
                        last[idx] = e;
                        break;
                    }
                }
            }
        }

        int prevEnd = -1;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i)-'a';
            if (last[idx] > end) {
                end = last[idx];
            }
            if (end == i) {
                result.add(end-prevEnd);
                prevEnd = end;
            }
        }
        return result;
    }
}
