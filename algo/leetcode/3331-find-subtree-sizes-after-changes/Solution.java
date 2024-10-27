import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    class TreeNode {
        public TreeNode parent = null;
        public HashSet<TreeNode> children = new HashSet<>();
        public int sz = 1;
        public int key = 0;
        public char val = 'a';
        public TreeNode(int key, char val) {
            this.key = key;
            this.val = val;
        }
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        TreeNode root = new TreeNode(0, s.charAt(0));
        nodes.put(root.key, root);
        for (int i = 1; i < parent.length; i++) {
            TreeNode node = new TreeNode(i, s.charAt(i));
            nodes.put(i, node);
        }
        for (int i = 1; i < parent.length; i++) {
            TreeNode p = nodes.get(parent[i]);
            TreeNode node = nodes.get(i);
            node.parent = p;
            if (p != null) {
                p.children.add(node);
            }
        }
        dfs_modify(root, new HashMap<>());
        dfs_size(root);

        int[] res = new int[parent.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nodes.get(i).sz;
        }
        return res;
    }
    private int dfs_size(TreeNode node) {
        if (node.children.size() == 0) {
            node.sz = 1;
            return node.sz;
        }
        int sz = 0;
        for (TreeNode child : node.children) {
            sz += dfs_size(child);
        }
        node.sz = sz+1;
        return node.sz;
    }
    private void dfs_modify(TreeNode node, HashMap<Character, TreeNode> path) {
        TreeNode anc = path.get(node.val);
        if (anc != null) {
            node.parent.children.remove(node);
            anc.children.add(node);
            node.parent = anc;
        }
        path.put(node.val, node);
        List<TreeNode> a = new ArrayList<>();
        for (TreeNode child : node.children) {
            a.add(child);
        }
        for (TreeNode child : a) {
            dfs_modify(child, path);
        }
        path.put(node.val, anc);
    }
    public static void main(String[] args) {
        test253();
        test2();
        test1();
    }
    public static void test1() {
        int[] parent = {-1,0,0,1,1,1};
        String s = "abaabc";
        int[] exp_output = {6,3,1,1,1,1};
        Solution sol = new Solution();
        int[] output = sol.findSubtreeSizes(parent, s);
        boolean passed = Arrays.equals(output, exp_output);
        System.out.println("test1:"+(passed ? "passed" : "failed"));
    }
    public static void test2() {
        int[] parent = {-1,0,4,0,1};
        String s = "abbba";
        int[] exp_output = {5,2,1,1,1};
        Solution sol = new Solution();
        int[] output = sol.findSubtreeSizes(parent, s);
        boolean passed = Arrays.equals(output, exp_output);
        System.out.println("test2:"+(passed ? "passed" : "failed"));
    }
    public static void test253() {
        int[] parent = {-1,10,0,12,10,18,11,12,2,3,2,2,2,0,4,11,4,2,0};
        String s = "babadabbdabcbaceeda";
        int[] exp_output = {19,1,15,2,3,1,1,1,1,1,5,2,4,1,1,1,1,1,2};
        Solution sol = new Solution();
        int[] output = sol.findSubtreeSizes(parent, s);
        boolean passed = Arrays.equals(output, exp_output);
        System.out.println("test253:"+(passed ? "passed" : "failed"));
    }
}