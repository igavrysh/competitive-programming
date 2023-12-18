import java.util.List;
import java.util.ArrayList;

public class SolutionDFS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {
        }
    
        TreeNode(int val) {
            this.val = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> output = new ArrayList<>();
        dfs(root, 0, output);
        return output;
    }

    private void dfs(TreeNode node, int l, List<Integer> output) {
        if (l == output.size()) {
            output.add(node.val);
        }

        if (node.right != null) {
            dfs(node.right, l+1, output);
        }

        if (node.left != null) {
            dfs(node.left, l+1, output);
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        TreeNode tn = new TreeNode(
                1,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(5)),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(4)));
        SolutionDFS s = new SolutionDFS();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 3
                && output.get(0) == 1
                && output.get(1) == 3
                && output.get(2) == 4;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        TreeNode tn = null;
        SolutionDFS s = new SolutionDFS();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        TreeNode tn = new TreeNode(1);
        SolutionDFS s = new SolutionDFS();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 1
                && output.get(0) == 1;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }
}
