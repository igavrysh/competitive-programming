import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class BSTIterator2 {
    private static class TreeNode {
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

    private static List<TreeNode> inorder_rec(TreeNode root) {
        List<TreeNode> order = new ArrayList<>();
        inorder_rec_helper(root, order);
        return order;
    }
    private static void inorder_rec_helper(TreeNode node, List<TreeNode> order) {
        if (node.left != null) {
            inorder_rec_helper(node.left, order);
        }
        order.add(node);
        if (node.right != null) {
            inorder_rec_helper(node.right, order);
        }
    }
    
    private static List<TreeNode> inorder(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        List<TreeNode> order = new ArrayList<>();
        if (root == null) {
            return order;
        }
        path.add(root);
        while (path.size() > 0) {
            TreeNode node = path.get(path.size()-1);
            if (!visited.contains(node)) {
                if (node.left != null && !visited.contains(node.left)) {
                    path.add(node.left);
                } else {
                    order.add(node);
                    visited.add(node);
                }
            } else if (node.right != null && !visited.contains(node.right)) {
                path.add(node.right);
            } else {
                path.remove(path.size()-1);
            }
        }
        return order;
    }

    List<TreeNode> order;
    int i = 0;

    public BSTIterator2(TreeNode root) {
        order = inorder(root);
    }
    public int next() {
        return order.get(i++).val;
    }
    public boolean hasNext() {
        return i<order.size();
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode root = new TreeNode(
            7,
            new TreeNode(3),
            new TreeNode(
                15,
                new TreeNode(9),
                new TreeNode(20)
            )
        );
        BSTIterator2 iter = new BSTIterator2(root);
        boolean passed = true;
        passed = passed && iter.next() == 3;
        passed = passed && iter.next() == 7;
        passed = passed && iter.hasNext();
        passed = passed && iter.next() == 9;
        passed = passed && iter.hasNext();
        passed = passed && iter.next() == 15;
        passed = passed && iter.hasNext();
        passed = passed && iter.next() == 20;
        passed = passed && !iter.hasNext();
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}