public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { 
        this.val = val;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    public TreeNode search(int val) {
        if (this.val == val) {
            return this;
        }

        if (left != null && this.val > val) {
            return left.search(val);
        }

        if (right != null && this.val < val) {
            return right.search(val);
        }

        return null;
    }


}
