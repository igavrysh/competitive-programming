package com.company;

public class SolutionRecursive {

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = invertTree(node.left);
        TreeNode right = invertTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

}
