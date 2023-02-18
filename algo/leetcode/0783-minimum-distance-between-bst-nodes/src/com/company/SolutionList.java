package com.company;

import java.util.ArrayList;
import java.util.List;

class SolutionList {
    public int minDiffInBST(TreeNode root) {
        List<Integer> els = new ArrayList<>();
        InorderDFS(root, els);
        int minDiff = Math.abs(els.get(0) - els.get(1));
        for (int i = 1; i < els.size()-1; i++) {
            int diff = Math.abs(els.get(i) - els.get(i+1));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }
 
    private void InorderDFS(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } 
        if (node.left != null) {
            InorderDFS(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            InorderDFS(node.right, list);
        }
    }
}