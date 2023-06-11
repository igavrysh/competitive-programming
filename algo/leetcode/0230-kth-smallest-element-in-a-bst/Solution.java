class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        inorder(root, k, new int[]{0}, res);
        return res[0];
    }

    private void inorder(TreeNode node, int k, int[] curr, int[] res) {
        if (curr[0] == k) {
            return;
        }

        if (node == null) {
            return;
        }

        inorder(node.left, k, curr, res);
        if (curr[0] == k) { return; }

        curr[0] = curr[0]+1;
        if (curr[0] == k) {
            res[0] = node.val;
            return;
        }

        inorder(node.right, k, curr, res);
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
    }

    public static void testSolution_1() {
        TreeNode root = new TreeNode(3, 
            new TreeNode(1, null, new TreeNode(2)),
            new TreeNode(4));
        Solution s = new Solution();
        int res = s.kthSmallest(root, 1);
        boolean passed = res == 1;
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        TreeNode root = new TreeNode(5,
            new TreeNode(3, 
                new TreeNode(2, 
                    new TreeNode(1, null, null),
                     null),
                new TreeNode(4, null, null)),
            new TreeNode(6, null, null));
        Solution s = new Solution();
        int res = s.kthSmallest(root, 3);
        boolean passed = res == 3;
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

}
