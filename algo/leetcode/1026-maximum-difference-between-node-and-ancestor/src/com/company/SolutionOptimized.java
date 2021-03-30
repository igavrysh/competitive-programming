package com.company;

public class SolutionOptimized {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return DFS(root, root.val, root.val);
    }

    private int DFS(TreeNode node, int currMin, int currMax) {
        if (node == null) {
            return currMax - currMin;
        }

        currMax = Math.max(currMax, node.val);
        currMin = Math.min(currMin, node.val);

        int lRes = DFS(node.left, currMin, currMax);
        int rRes = DFS(node.right, currMin, currMax);
        return Math.max(lRes, rRes);
    }
}
