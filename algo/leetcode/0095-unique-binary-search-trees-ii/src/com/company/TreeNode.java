package com.company;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> toList(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> output = new ArrayList<>();
        output.add(root.val);
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (level.size() != 0) {
            int currentSize = level.size();
            while (currentSize > 0) {
                TreeNode node = level.remove(0);
                if (node.left == null && node.right == null) {
                } else {
                    output.add(node.left != null ? node.left.val : null);
                    output.add(node.right != null ? node.right.val : null);
                }

                if (node.left != null) {
                    level.add(level.size(), node.left);
                }

                if (node.right != null) {
                    level.add(level.size(), node.right);
                }
                
                currentSize--;
            }
        }

        while (output.size() > 0 && output.get(output.size()-1) == null) {
            output.remove(output.size()-1);
        }

        return output;
    }
}
