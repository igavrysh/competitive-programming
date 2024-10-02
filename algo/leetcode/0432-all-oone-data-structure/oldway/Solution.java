package oldway;
import java.util.HashMap;;

class AllOne {
    public static class Node {
        public String key;
        public int fq;
        public Node left;
        public Node right;
        public Node(String key, int fq) {
            this.key = key;
            this.fq = fq;
        }
    }
    public HashMap<String, Node> map = new HashMap<>();
    public Node maxNode = new Node("", -1);
    public Node minNode = new Node("", -1);

    public AllOne() {
        maxNode.left = minNode;
        minNode.right = maxNode;
    }
    
    public void inc(String key) {
        if (map.get(key) == null) {
            Node newNode = new Node(key, 0);
            Node nextToMinNode = minNode.right;
            minNode.right = newNode;
            newNode.left = minNode;

            newNode.right = nextToMinNode;
            nextToMinNode.left = newNode;
            map.put(key, newNode);
        }

        Node node = map.get(key);
        node.right.left = node.left;
        node.left.right = node.right;

        node.fq++;
        Node curr = node.right;
        while (curr.fq <= node.fq && curr.fq != -1) {
            curr = curr.right;
        }

        Node currLeft = curr.left;
        currLeft.right = node;
        node.left = currLeft;

        node.right = curr;
        curr.left = node;
    }
    
    public void dec(String key) {
        Node node = map.get(key);
        node.right.left = node.left;
        node.left.right = node.right;

        node.fq--;
        if (node.fq == 0) {
            map.remove(key);
            return;
        }

        Node curr = node.left;
        while (curr.fq > node.fq && curr.fq != -1) {
            curr = curr.left;
        }

        Node currRight = curr.right;
        curr.right = node;
        node.left = curr;
        
        currRight.left = node;
        node.right = currRight;
    }
    
    public String getMaxKey() {
        return maxNode.left.key;
    }
    
    public String getMinKey() {
        return minNode.right.key;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        AllOne sol = new AllOne();
        boolean passed = true;
        sol.inc("hello");
        sol.inc("hello");
        passed = passed && sol.getMaxKey().equals("hello");
        passed = passed && sol.getMinKey().equals("hello");
        sol.inc("leet");
        passed = passed && sol.getMaxKey().equals("hello");
        passed = passed && sol.getMinKey().equals("leet");
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}