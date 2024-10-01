import java.util.HashMap;
import java.util.HashSet;

class AllOne2 {
    private static class Node {
        public HashSet<String> keys = new HashSet<>();
        public int fq = -1;
        public Node next;
        public Node prev;
        public Node() {}
        public Node(String key, int fq) { keys.add(key); this.fq = fq; }
    }
    private HashMap<String, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    public AllOne2() {
        head = new Node();
        tail = new Node();
        tail.next = head;
        head.prev = tail;
    }
    private void insert_next(Node new_node, Node node) {
        // node | new_node | node_next
        Node node_next = node.next;
        node.next = new_node;
        new_node.prev = node;
        new_node.next = node_next;
        node_next.prev = new_node;
    }
    private void insert_prev(Node new_node, Node node) {
        // node_prev | new_node | node
        Node node_prev = node.prev;
        node_prev.next = new_node;
        new_node.prev = node_prev;
        new_node.next = node;
        node.prev = new_node;
    }
    private void remove(Node node) {
        // node_prev | node | node_next
        Node node_next = node.next;
        Node node_prev = node.prev;
        node_prev.next = node_next;
        node_next.prev = node_prev;
        node.next = null;
        node.prev = null;
    }
    public void inc(String key) {
        Node node = map.get(key);
        if (node == null) {
            if (tail.next.fq != 1) {
                node = new Node(key, 1);
                insert_next(node, tail);
                map.put(key, node);
            } else {
                tail.next.keys.add(key);
                map.put(key, tail.next);
            }
        } else {
            node.keys.remove(key);
            if (node.next.fq == node.fq+1) {
                node.next.keys.add(key);
                map.put(key, node.next);
            } else {
                Node new_node = new Node(key, node.fq+1);
                insert_next(new_node, node);
                map.put(key, new_node);
            }
            if (node.keys.size() == 0) {
                remove(node);
            }
        }
    }
    public void dec(String key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        
        node.keys.remove(key);

        if (node.prev.fq == node.fq-1) {
            map.put(key, node.prev);
            node.prev.keys.add(key);
        } else if (node.fq != 1) {
            Node new_node = new Node(key, node.fq-1);
            insert_prev(new_node, node);
            map.put(key, new_node);
        }
        
        if (node.keys.size() == 0) {
            remove(node);
        }
    }
    public String getMaxKey() {
        return !head.prev.keys.isEmpty() ? head.prev.keys.iterator().next() : "";
    }
    public String getMinKey() {
        return !tail.next.keys.isEmpty() ? tail.next.keys.iterator().next() : "";
    }
    public static void main(String[] args) {
        test1();
        test3();
        test2();
    }

    public static void test1() {
/*
["AllOne","inc",    "inc",  "inc",  "inc",  "inc",  "dec",  "dec",  "getMaxKey",    "getMinKey"]
[[],        ["a"],  ["b"],  ["b"],  ["b"],  ["b"],  ["b"],  ["b"],  [],             []]
 */
        AllOne2 sol = new AllOne2();
        boolean passed = true;
        sol.inc("a"); // a:1
        sol.inc("b"); // a:1 b:1
        sol.inc("b"); // a:1 b:2
        sol.inc("b"); // a:1 b:3
        sol.inc("b"); // a:1 b:4
        sol.dec("b"); // a:1 b:3
        sol.dec("b"); // a:1 b:2
        passed = passed && sol.getMaxKey().equals("b");
        passed = passed && sol.getMinKey().equals("a");
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
/*
["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]

Use Testcase
Output
[null,null,null,null,null,null,null,null,null,"a",null,"c",""]
Expected
[null,null,null,null,null,null,null,null,null,"a",null,"c","c"]
 */
        AllOne2 sol = new AllOne2();
        boolean passed = true;
        sol.inc("a");
        sol.inc("b");
        sol.inc("b");
        sol.inc("c");
        sol.inc("c");
        sol.inc("c");
        sol.dec("b");
        sol.dec("b");
        passed = passed && sol.getMinKey() == "a";
        sol.dec("a");
        passed = passed && sol.getMaxKey() == "c";
        passed = passed && sol.getMinKey() == "c";
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
    public static void test3() {
/*
["AllOne",  "inc",  "inc",  "inc",  "inc",  "inc",  "inc",  "inc",  "inc",  "inc",  "inc",  "inc","inc","getMinKey"]
[[],        ["a"],  ["b"],  ["c"],  ["d"],  ["a"],  ["b"],  ["c"],  ["d"],  ["c"],  ["d"],  ["d"],["a"],[]]

Use Testcase
Output
[null,null,null,null,null,null,null,null,null,null,null,null,null,""]
Expected
[null,null,null,null,null,null,null,null,null,null,null,null,null,"b"]
 */
        AllOne2 sol = new AllOne2();
        boolean passed = true;
        sol.inc("a");  // a:1
        sol.inc("b");  // a:1 b:1
        sol.inc("c");  // a:1 b:1 c:1
        sol.inc("d");  // a:1 b:1 c:1 d:1
        sol.inc("a");  // a:2 b:1 c:1 d:1
        sol.inc("b");  // a:2 b:2 c:1 d:1
        sol.inc("c");  // a:2 b:2 c:2 d:1
        sol.inc("d");  // a:2 b:2 c:2 d:2
        sol.inc("c");  // a:2 b:2 c:3 d:2
        sol.inc("d");  // a:2 b:2 c:3 d:3
        sol.inc("d");  // a:2 b:2 c:3 d:4
        sol.inc("a");  // a:3 b:2 c:3 d:4
        passed = passed && sol.getMinKey() == "b";
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }
}
