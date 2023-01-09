package com.company;

class SolutionRange {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        if (root.left != null) {
            if (!isValidBST(root.left, min, (long) root.val)) {
                return false;
            }
        }

        if (root.right != null) {
            if (!isValidBST(root.right, (long) root.val, max)) {
                return false;
            }
        }
        return true;
    }
}