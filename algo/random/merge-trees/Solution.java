import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static class Node {
        public String name;
        public String value;
        public HashMap<String, ArrayList<Node>> childNodes;
        public Node(String name, String value, ArrayList<Node> childNodes) {
            this.name = name;
            this.value = value;
            this.childNodes = new HashMap<>();
            if (childNodes != null) {
                this.childNodes = new HashMap<>();
                for (int i = 0; i < childNodes.size(); i++) {
                    Node childNode = childNodes.get(i);


                    
                    Node cpNode = new Node(childNode.name, childNode.value, childNode.childNodes);

                    
                    this.childNodes.put(node.value, a);
                }
            }
        }
    }

    public Node merge(Node root1, Node root2) {
        return null;
    }

    public static void main(String[] args) {
    }

    public static void test1() {
        Node t1 = new Node("t1", "t1", new ArrayList<>() {{ add }});
    }
}