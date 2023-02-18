package com.company;

public class SolutionPrevNodeOptimized {
    private TreeNode prev;
    private int minDiff;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        InorderDFS(root);
        return minDiff;
    }
 
    private void InorderDFS(TreeNode node) {
        if (node == null) {
            return;
        } 
        if (node.left != null) {
            InorderDFS(node.left);
        }
        if (prev != null) {
            int diff = Math.abs(prev.val - node.val);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        prev = node;
        if (node.right != null) {
            InorderDFS(node.right);
        }
    }
}
