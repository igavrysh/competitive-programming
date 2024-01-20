import java.util.Arrays;

public class SolutionPreOrder {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] lrMaxH = new int[100_000];
        int[] rlMaxH = new int[100_000];
        preOrder(root, 0, lrMaxH, new int[]{-1,-1}, true);
        preOrder(root, 0, rlMaxH, new int[]{-1,-1}, false);
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int nodeId = queries[i]-1;
            res[i] = Math.max(lrMaxH[nodeId], rlMaxH[nodeId]);
        }
        return res;
    }

    void preOrder(TreeNode node, int h, int[] maxHTrailing, int[] maxHHist, boolean isLR) {
        maxHHist[0] = maxHHist[1];
        maxHHist[1] = Math.max(h, maxHHist[0]);
        maxHTrailing[node.val-1] = maxHHist[0];
        if (isLR) {
            if (node.left != null) {
                preOrder(node.left, h+1, maxHTrailing, maxHHist, isLR);
            }
            if (node.right != null) {
                preOrder(node.right, h+1, maxHTrailing, maxHHist, isLR);
            }
        } else {
            if (node.right != null) {
                preOrder(node.right, h+1, maxHTrailing, maxHHist, isLR);
            }
            if (node.left != null) {
                preOrder(node.left, h+1, maxHTrailing, maxHHist, isLR);
            }
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
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
        SolutionPreOrder sol = new SolutionPreOrder();
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
        SolutionPreOrder sol = new SolutionPreOrder();
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
        SolutionPreOrder sol = new SolutionPreOrder();
        int[] output = sol.treeQueries(root, queries);
        boolean passed = Arrays.equals(output, expOutput);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
