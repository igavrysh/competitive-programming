package com.company;

public class SolutionPractice2 {

    private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!isValidBST(node.left)) {
            return false;
        }
        
        if (prev != null && prev.val >= node.val) {
            return false;
        }

        prev = node;

        if (!isValidBST(node.right)) {
            return false;
        }
        return true;
    }

    
}
