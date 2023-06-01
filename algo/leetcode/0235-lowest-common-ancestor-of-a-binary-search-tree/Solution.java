class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] output = new TreeNode[1];
        dfs(root, output, p, q);
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

        if (num < 2 && dfs(node.left, output, p, q)) {
            num++;
        } 
        if (num < 2 && dfs(node.right, output, p, q)) {
            num++;
        }

        if (num >= 2 && output[0] == null) {
            output[0] = node;
        }

        return num >= 1;
    }

    public static void main(String[] args) {
        testSolution1_1();
        testSolution1_2();
        testSolution1_3();
        testSolution1_4();
        testSolution1_5();
    }

    public static void testSolution1_1() {
        TreeNode root = new TreeNode(
            6,
            new TreeNode(
                2,
                new TreeNode(0),
                new TreeNode(
                    4,
                    new TreeNode(3),
                    new TreeNode(5))),
            new TreeNode(
                8,
                new TreeNode(7),
                new TreeNode(9)));
        
        
        Solution sol = new Solution();
        TreeNode res = sol.lowestCommonAncestor(root, root.search(2), root.search(8));
        boolean passed = res != null
            && res.val == 6;
        System.out.println("testSolution1_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_2() {
        TreeNode root = new TreeNode(
            6,
            new TreeNode(
                2,
                new TreeNode(0),
                new TreeNode(
                    4,
                    new TreeNode(3),
                    new TreeNode(5))),
            new TreeNode(
                8,
                new TreeNode(7),
                new TreeNode(9)));
        
        
        Solution sol = new Solution();
        TreeNode res = sol.lowestCommonAncestor(root, 
            root.search(2), root.search(4));
        boolean passed = res != null
            && res.val == 2;
        System.out.println("testSolution1_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_3() {
        TreeNode root = new TreeNode(
            2,
            new TreeNode(1),
            null);
        
        Solution sol = new Solution();
        TreeNode res = sol.lowestCommonAncestor(root, 
            root.search(2), root.search(1));
        boolean passed = res != null
            && res.val == 2;
        System.out.println("testSolution1_3: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_4() {
        TreeNode root = new TreeNode(
            2,
            new TreeNode(1),
            null);
        
        Solution sol = new Solution();
        TreeNode res = sol.lowestCommonAncestor(root, 
            root.search(2), root.search(2));
        boolean passed = res != null
            && res.val == 2;
        System.out.println("testSolution1_4: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution1_5() {
        TreeNode root = new TreeNode(1);
        Solution sol = new Solution();
        TreeNode res = sol.lowestCommonAncestor(root, 
            new TreeNode(2), new TreeNode(3));
        boolean passed = res == null;
        System.out.println("testSolution1_5: " + (passed ? "passed" : "failed"));
    }
    
}