import java.util.Stack;
class BSTIterator {
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
        while (!path.isEmpty()) {
            if (states.peek() == 0) {
                states.pop();
                states.push(1);
                break;
            } else if (states.peek() == 1) {
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
            } else if (states.peek() == 2) {
                states.pop();
                path.pop();
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return !path.isEmpty();
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
        BSTIterator iter = new BSTIterator(root);
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

