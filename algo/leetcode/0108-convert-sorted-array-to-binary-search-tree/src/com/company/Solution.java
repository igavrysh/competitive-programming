package com.company;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode output = helper(nums, 0, nums.length-1);
        return output;
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int middle = (l + r) / 2;

        TreeNode leftSubtree = helper(nums, l, middle-1);
        TreeNode rightSubtree = helper(nums, middle + 1, r);

        TreeNode node = new TreeNode(nums[(l + r) / 2]);
        node.left = leftSubtree;
        node.right = rightSubtree;
        return node;
    }
}
