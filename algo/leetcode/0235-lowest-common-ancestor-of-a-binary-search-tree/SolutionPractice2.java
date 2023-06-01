public class SolutionPractice2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }
        TreeNode[] output = new TreeNode[1];
        dfs(root, output, p.val < q.val ? p : q, p.val < q.val ? q : p);
        return output[0];
    }

    private boolean dfs(TreeNode node, TreeNode[] output, TreeNode p, TreeNode q) {
        if (output[0] != null) { 
            return false; 
        }
        if (node == null) {
            return false;
        }

        int num = 0;
        if (node.val == p.val) {
            num++;
        }

        if (node.val == q.val) {
            num++;
        }

        if (num < 2 && node.val >= p.val && dfs(node.left, output, p, q)) {
            num++;
        } 

        if (num < 2 && output[0] == null && node.val <= q.val && dfs(node.right, output, p, q)) {
            num++;
        }

        if (num >= 2 && output[0] == null) {
            output[0] = node;
        }

        return num >= 1;
    }
}
