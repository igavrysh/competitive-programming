package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        List<TreeNode> Q = new ArrayList<>();
        Q.add(root);
        boolean fromStart = true;
        while (Q.size() > 0) {
            int counter = Q.size();
            List<Integer> level = new ArrayList<>();
            while (counter > 0) {
                TreeNode node = Q.remove(0);
                level.add(node.val);
                counter--;
                if (fromStart) {
                    if (node.left != null) {
                        Q.add(counter, node.left);
                    }
                    if (node.right != null) {
                        Q.add(counter, node.right);
                    }
                } else {
                    if (node.right != null) {
                        Q.add(counter, node.right);
                    }
                    if (node.left != null) {
                        Q.add(counter, node.left);
                    }
                }
            }
            output.add(level);
            fromStart = !fromStart;
        }
        return output;
    }
}


