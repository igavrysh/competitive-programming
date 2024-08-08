/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> path = new Stack<>();
    Stack<Integer> states = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            path.add(node);
            if (node.left == null) {
                states.add(1);
                break;
            } else {
                states.add(0);
            }
            node = node.left;
        }
    }
    public int next() {
        int res = path.peek().val;
        path.pop();
        states.pop();
        while (!path.isEmpty()) {
            if (states.peek() == 0) {
                states.pop();
                states.push(1);
                break;
            }
            if (states.peek() == 1) {
                TreeNode curr = path.peek();
                states.pop();
                states.push(2);
                TreeNode node = curr.right;
                while (node != null) {
                    path.add(node);
                    if (node.left == null) {
                        states.add(1);
                        break;
                    } else {
                        states.add(0);
                    }
                    node = node.left;
                }
                if (path.peek() == curr) {
                    states.pop();
                    path.pop();
                } else {
                    break;
                }
            }
            if (states.peek() == 2) {
                states.pop();
                path.pop();
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return !path.isEmpty();
    }
}

