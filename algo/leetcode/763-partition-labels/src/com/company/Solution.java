package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> lastOccur = new HashMap<>();

        for (int s = 0; s < S.length(); s++) {
            char first = S.charAt(s);
            for (int e = S.length()-1; e>s; e--) {
                if (S.charAt(e) == first) {
                    lastOccur.put(first, e);
                    break;
                }
            }
        }

        HashSet<Character> pending = new HashSet<>();
        int prevEnd = -1;
        for (int s = 0; s < S.length(); s++) {
            pending.add(S.charAt(s));

            boolean completeString = true;
            for (Character c : pending) {
                if (lastOccur.get(c) > s) {
                    completeString = false;
                    break;
                }
            }

            if (completeString) {
                result.add(s-prevEnd);
                prevEnd = s;
                s = prevEnd;
                pending = new HashSet<>();
            }
        }
        return result;

    }

}
