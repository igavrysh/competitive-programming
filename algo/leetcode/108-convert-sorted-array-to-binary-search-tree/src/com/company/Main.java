package com.company;

public class Main {

    public static void test1() {
        int[] nums = {-10,-3,0,5,9};
        Solution s = new Solution();
        TreeNode output = s.sortedArrayToBST(nums);
        boolean passed = output.val == 0
                && output.left.val == -3
                && output.left.left.val == -10
                && output.left.right == null
                && output.right.val == 9
                && output.right.left.val == 5
                && output.right.right == null;
        System.out.println("test 1" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] nums = {};
        Solution s = new Solution();
        TreeNode output = s.sortedArrayToBST(nums);
        boolean passed = output == null;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
	    test1();
	    test2();
    }
}
