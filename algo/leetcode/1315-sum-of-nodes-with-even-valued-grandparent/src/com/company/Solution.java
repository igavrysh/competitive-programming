package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        Set<TreeNode> acc = new HashSet<>();
        DFS(root, -1, acc);
        int output = 0;
        for (TreeNode n : acc) {
            output += n.val;
        }
        return output;
    }

    private void DFS(TreeNode node, int sumLevel, Set<TreeNode> acc) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            DFS(node.left, 1, acc);
            DFS(node.right, 1, acc);
        } else {
            DFS(node.left, -1, acc);
            DFS(node.right, -1, acc);
        }

        if (sumLevel == 0) {
            acc.add(node);
        }

        DFS(node.left, sumLevel == -1 ? -1 : sumLevel - 1, acc);
        DFS(node.right, sumLevel == -1 ? -1 : sumLevel - 1, acc);
    }
}
