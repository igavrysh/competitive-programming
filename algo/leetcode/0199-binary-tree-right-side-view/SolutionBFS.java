import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionBFS {

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
        Queue<TreeNode> currLevel = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        currLevel.offer(root);
        List<Integer> output = new ArrayList<>();

        while (currLevel.size() != 0) {
            int currLevelSize = currLevel.size();
            output.add(((LinkedList<TreeNode>) currLevel).getLast().val);
            while (currLevelSize > 0) {
                TreeNode tn = currLevel.poll();
                if (tn.left != null) {
                    currLevel.offer(tn.left);
                }
                if (tn.right != null) {
                    currLevel.offer(tn.right);
                }
                currLevelSize--;
            }
        }

        return output;
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
        SolutionBFS s = new SolutionBFS();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 3
                && output.get(0) == 1
                && output.get(1) == 3
                && output.get(2) == 4;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        TreeNode tn = null;
        SolutionBFS s = new SolutionBFS();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 0;
        System.out.println("test2:" + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        TreeNode tn = new TreeNode(1);
        SolutionBFS s = new SolutionBFS();
        List<Integer> output = s.rightSideView(tn);
        boolean passed = output.size() == 1
                && output.get(0) == 1;
        System.out.println("test3:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
