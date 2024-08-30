import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Solution {
    public static class TreeNode {
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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] output = {0};
        HashMap<Integer, Integer> fq = new HashMap<>();
        dfs(root, new ArrayList<>(), output, fq);
        return output[0];
    }
    private void dfs(TreeNode node, ArrayList<Integer> path, int[] output, HashMap<Integer, Integer> fq) {
        path.add(path.size(), node.val);
        fq.put(node.val, fq.getOrDefault(node.val, 0)+1);
        if (node.left == null && node.right == null) {
            if (is_p(path, fq)) {
                output[0]++;
            }
        } else {
            if (node.left != null) {
                dfs(node.left, path, output, fq);
            }
            if (node.right != null) {
                dfs(node.right, path, output, fq);
            }
        }
        if (fq.get(node.val) == 1) {
            fq.remove(node.val);
        } else {
            fq.put(node.val, fq.getOrDefault(node.val, 0)-1);
        }
        path.remove(path.size()-1);
    }
    private boolean is_p(List<Integer> path, HashMap<Integer, Integer> fq) {
        int n = path.size();
        int c_odd = 0;
        for (Integer key : fq.keySet()) {
            if (fq.get(key)%2 == 1) {
                c_odd++;
                if (c_odd > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        TreeNode root = new TreeNode(
            2,
            new TreeNode(
                3,
                new TreeNode(3),
                null
            ),
            new TreeNode(
                1,
                new TreeNode(1),
                null
            )
        );
        int expOutput = 2;
        Solution sol = new Solution();
        int output = sol.pseudoPalindromicPaths(root);
        boolean passed = expOutput == output;
        System.out.println("test1:"+(passed ? "passed" : "failed"));
    }
}