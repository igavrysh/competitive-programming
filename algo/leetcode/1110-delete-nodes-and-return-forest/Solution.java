import java.util.ArrayList;
import java.util.HashSet;
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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> todel = new HashSet<>();
        for (int todo : to_delete) {
            todel.add(todo);
        }

        List<TreeNode> acc = new ArrayList<>();
        dfs(root, null, true, true, todel, acc);
        return acc;
    }

    private void dfs(TreeNode node, TreeNode parent, boolean isLeftBranch, boolean isRoot, HashSet<Integer> todel, List<TreeNode> acc) {
        if (node == null) {
            return;
        }

        if (isRoot && !todel.contains(node.val)) {
            acc.add(node);
        }

        boolean isDel = todel.contains(node.val);
        if (isDel) {
            if (parent != null) {
                if (isLeftBranch) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }

        dfs(node.left, node, true, isDel, todel, acc);
        dfs(node.right, node, false, isDel, todel, acc);
    }

    public static void main(String[] args) {
        
    }
}