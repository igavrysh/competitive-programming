import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int l = Q.size();
            for (int i = 0; i < l; i++) {
                TreeNode n = Q.poll();
                if (n == null) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append("null");
                } else {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(n.val);
                    Q.offer(n.left);
                    Q.offer(n.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> Q = new LinkedList<>();
        TreeNode root = null;
        if (!nodes[0].equals("null")) {
            root = new TreeNode(Integer.valueOf(nodes[0]));
        }
        Q.add(root);
        int idx = 1;
        while (!Q.isEmpty()) {
            int l = Q.size();
            for (int i = 0; i < l; i++) {
                TreeNode node = Q.poll();
                if (idx >= nodes.length) {
                    break;
                }
                if (nodes[idx].equals("null")) {
                    node.left = null;
                    idx++;
                } else {
                    node.left = new TreeNode(Integer.valueOf(nodes[idx]));
                    Q.offer(node.left);
                    idx++;
                }

                if (nodes[idx].equals("null")) {
                    node.right = null;
                    idx++;
                } else {
                    node.right = new TreeNode(Integer.valueOf(nodes[idx]));
                    Q.offer(node.right);
                    idx++;
                }
            }
        }
        return root;
    }
    
}