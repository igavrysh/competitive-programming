package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<Integer>> outputIdxs = new ArrayList<>();
        helper(0, new ArrayList<>(), outputIdxs, s);
        List<String> output = new ArrayList<>();
        for (List<Integer> idxs : outputIdxs) {
            StringBuilder sb = new StringBuilder();
            int prev = -1;
            for (int i = 0; i < idxs.size(); i++) {
                int idx = idxs.get(i);
                sb.append(s.substring(prev+1, idx+1));
                sb.append('.');
                prev = idx;
            }
            sb.append(s.substring(prev+1, s.length()));
            output.add(sb.toString());
        }
        return output;
    }

    protected void helper(int start, List<Integer> candidate, List<List<Integer>> output, String s) {
        if (candidate.size() == 3) {
            if (checkIpPart(s.substring(candidate.get(2)+1, s.length()))) {
                output.add(new ArrayList<>(candidate));
            }
            return;
        }

        for (int i = start; i < s.length()-1; i++) {
            int prevIndx = candidate.size() == 0 ? -1 : candidate.get(candidate.size()-1);
            String c = s.substring(prevIndx+1, i+1);
            if (checkIpPart(c)) {
                candidate.add(i);
                helper(i+1, candidate, output, s);
                candidate.remove(candidate.size()-1);
            }
        }
    }

    protected boolean checkIpPart(String s) {
        try {
            int t = Integer.valueOf(s);
            return (t > 0 && t <= 255 && s.charAt(0) != '0') || (s.length() == 1 && t == 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}