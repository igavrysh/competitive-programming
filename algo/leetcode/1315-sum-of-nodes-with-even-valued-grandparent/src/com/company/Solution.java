package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        int output = DFS(root, null, null);
        return output;
    }

    private int DFS(TreeNode node, TreeNode grandparent, TreeNode parent) {
        int output = 0;
        if (node == null) {
            return 0;
        }
        if (grandparent != null) {
            if (grandparent.val % 2 == 0) {
                output += node.val;
            }
        }
        output += DFS(node.left, parent, node) + DFS(node.right, parent, node);
        return output;
    }
}
