package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return gen(1, n+1) ;
    }

    // s inclusive, e exclusive
    public List<TreeNode> gen(int s, int e) {
        if (s == e) {
            return new ArrayList<>();
        }

        if (s+1 == e) {
            return Arrays.asList(new TreeNode(s));
        }

        List<TreeNode> output = new ArrayList<>();
        for (int i = s; i < e; i++) {
            List<TreeNode> l = gen(s, i);
            List<TreeNode> r = gen(i+1, e);
            if (i == s) {
                l.add(null);
            }
            if (i == e-1) {
                r.add(null);
            }
            for (int iL = 0; iL < l.size(); iL++) {
                for (int iR = 0; iR < r.size(); iR++) {
                    TreeNode lTree = iL != l.size() ? l.get(iL) : null;
                    TreeNode rTree = iR != r.size() ? r.get(iR) : null;
                    output.add(new TreeNode(i, lTree, rTree));
                }
            }
        }

        return output;
    }
}