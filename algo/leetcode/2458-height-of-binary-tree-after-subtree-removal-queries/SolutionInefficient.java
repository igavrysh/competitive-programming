import java.util.Arrays;

class SolutionInefficient {

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = dfsSize(root);
        int[][] acc = new int[n][5];
        dfs(root, null, acc);
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int nodeToRemove = queries[i]-1;
            int parent = acc[nodeToRemove][0];
            int[] parentA = acc[parent];
            if (parentA[3] == nodeToRemove) {
                res[i] = updToRoot(parent, 0, parentA[2], root.val-1, acc);
            } else if (parentA[4] == nodeToRemove) {
                res[i] = updToRoot(parent, parentA[1], 0, root.val-1, acc);
            }
        }
        return res;
    }

    private int dfsSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int size = 1;
        size += node.left != null ? dfsSize(node.left) : 0;
        size += node.right != null ? dfsSize(node.right) : 0;
        return size;
    }

    // idx = node itself, [idx][0] - parent, [idx][1] - left subtree h, [idx][2] - right subtree h
    // [idx][3] - left child node val, [idx][4] - right child node val
    private int dfs(TreeNode node, TreeNode parent, int[][] acc) {
        int lheight = node.left != null ? 1 + dfs(node.left, node, acc) : 0;
        int rheight = node.right != null ? 1 + dfs(node.right, node, acc) : 0;
        acc[node.val-1] = new int[] { 
            parent != null ? parent.val-1 : -1, 
            lheight, 
            rheight, 
            node.left != null ? node.left.val-1 : -1,
            node.right != null ? node.right.val-1 : -1
        };
        return Math.max(lheight, rheight) > 0 ? Math.max(lheight, rheight) : 0;
    }

    private int updToRoot(int node, int lheight, int rheight, int root, int[][] acc) {
        if (node == root) { return Math.max(lheight, rheight) == 0 ? 0 : Math.max(lheight, rheight); }
        int[] rec = acc[node];
        int[] parent_rec = acc[rec[0]];
        int lParentHeight = 0;
        int rParentHeight = 0;
        int newHeight = 1 + Math.max(lheight, rheight);
        // update coming from left subtree
        if (parent_rec[3] == node) {
            lParentHeight = newHeight;
            rParentHeight = parent_rec[2];
        }
        // update is coming from right subtree
        else if (parent_rec[4] == node) {
            lParentHeight = parent_rec[1];
            rParentHeight = newHeight;
        }
        return updToRoot(rec[0], lParentHeight, rParentHeight, root, acc);
    }

    public static void main(String[] args) {
        test3();
        test1();
        test2();
    }

    public static void test1() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(
                3,
                new TreeNode(2),
                null),
            new TreeNode(
                4,
                new TreeNode(6),
                new TreeNode(
                    5,
                    null,
                    new TreeNode(7)
                ))
        );
        int[] queries = {4};
        int[] expOutput = {2};
        SolutionInefficient sol = new SolutionInefficient();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode root = new TreeNode(
            5,
            new TreeNode(
                8,
                new TreeNode(
                    2,
                    new TreeNode(4),
                    new TreeNode(6)),
                new TreeNode(1)),
            new TreeNode(
                9,
                new TreeNode(3),
                new TreeNode(7))
        );
        int[] queries = {3,2,4,8};
        int[] expOutput = {3,2,3,2};
        SolutionInefficient sol = new SolutionInefficient();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        TreeNode root = new TreeNode(
            1,
            null,
            new TreeNode(
            5,
                new TreeNode(
                    3,
                    new TreeNode(2),
                    new TreeNode(4)),
                null)
        );
        int[] queries = {3,5,4,2,4};
        int[] expOutput = {1,0,3,3,3};
        SolutionInefficient sol = new SolutionInefficient();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
