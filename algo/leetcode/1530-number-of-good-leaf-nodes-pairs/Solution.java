class Solution {
    private static class TreeNode {
        @SuppressWarnings("unused")
        int val;
        TreeNode left;
        TreeNode right;
        @SuppressWarnings("unused")
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int countPairs(TreeNode root, int distance) {
        int[] res = {0};
        dfs(root, distance, res);
        return res[0];
    }
    private int[] dfs(TreeNode node, int distance, int[] res) {
        if (node.left == null && node.right == null) {
            int[] h = new int[11];
            h[1] = 1;
            return h;
        }
        int[] l_h = new int[11];
        int[] r_h = new int[11];
        if (node.left != null) {
            l_h = dfs(node.left, distance, res);
        }
        if (node.right != null) {
            r_h = dfs(node.right, distance, res);
        }
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i + j <= distance) {
                    res[0] += l_h[i] * r_h[j];
                }
            }
        }
        int[] h = new int[11];
        for (int i = 1; i < 10; i++) {
            h[i+1] = l_h[i] + r_h[i];
        }
        return h;
    }

    public static void main(String[] args) {
        test3();
        test2();
        test1();
    }

    public static void test1() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(
                2,
                null,
                new TreeNode(4)
            ),
            new TreeNode(3)
        );
        int distance = 3;
        int expOutput = 1;
        Solution sol = new Solution();
        int output = sol.countPairs(root, distance);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(4),
                new TreeNode(5)
            ),
            new TreeNode(
                3,
                new TreeNode(6),
                new TreeNode(7)
            )
        );
        int distance = 3;
        int expOutput = 2;
        Solution sol = new Solution();
        int output = sol.countPairs(root, distance);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        TreeNode root = new TreeNode(
            7,
            new TreeNode(
                1,
                new TreeNode(6),
                null
            ),
            new TreeNode(
                4,
                new TreeNode(5),
                new TreeNode(
                    3,
                    null,
                    new TreeNode(2)
                )
            )
        );
        int distance = 3;
        int expOutput = 1;
        Solution sol = new Solution();
        int output = sol.countPairs(root, distance);
        boolean passed = output == expOutput;
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}