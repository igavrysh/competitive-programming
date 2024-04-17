class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int count(TreeNode root) {
        if (root==null) return 0;
        return 1+count(root.left)+count(root.right);
    }

    public boolean dfs(TreeNode root,int total,int i) {
        if (root==null) return true;

        if (i>total) return false;

        return dfs(root.left,total,2*i)&& dfs(root.right,total,2*i+1);
    }

    public boolean isCompleteTree(TreeNode root) {
        int total=count(root);
        return dfs(root,total,1);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(4),
                new TreeNode(5)),
            new TreeNode(
                3,
                new TreeNode(6),
                null)
        );
        boolean expOutput = true;
        Solution sol = new Solution();
        boolean output = sol.isCompleteTree(root);
        boolean passed = output == expOutput;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(4),
                new TreeNode(5)),
            new TreeNode(
                3,
                null,
                new TreeNode(7))
        );
        boolean expOutput = false;
        Solution sol = new Solution();
        boolean output = sol.isCompleteTree(root);
        boolean passed = output == expOutput;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }
}
