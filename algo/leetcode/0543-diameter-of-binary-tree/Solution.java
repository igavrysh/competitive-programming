import javax.swing.tree.TreeNode;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {        
        if (root == null) {
            return 0;
        }
        int[] d = {0};
        dfs(root, d);
        return d[0]-1;
    }

    private int dfs(TreeNode node, int[] d) {
        if (node.left == null && node.right == null) {
            d[0] = Math.max(d[0], 1);
            return 1;
        }

        int lDepth = 0;
        if (node.left != null) {
            lDepth = dfs(node.left, d);
        }

        int rDepth = 0;
        if (node.right != null) {
            rDepth = dfs(node.right, d);
        }

        d[0] = Math.max(d[0], rDepth+lDepth+1);

        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int expectedOutput = 3;
        Solution s = new Solution();
        int output = s.diameterOfBinaryTree(node);
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode node = null;
        int expectedOutput = 0;
        Solution s = new Solution();
        int output = s.diameterOfBinaryTree(node);
        boolean passed = output == expectedOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
    
}