import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
    public Node cloneGraph(Node root) {
        if (root == null) {
            return null;
        }
        Node[] nodes = new Node[101];
        Node rootCopy = new Node(root.val);
        nodes[root.val] = rootCopy;
        dfs(root, rootCopy, nodes);
        return rootCopy;
    }

    private void dfs(Node node, Node copyNode, Node[] nodes) {
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node childNode = node.neighbors.get(i);
            Node childCopyNode = nodes[childNode.val]; 
            if (childCopyNode == null) {
                childCopyNode = new Node(childNode.val);
                nodes[childNode.val] = childCopyNode;
                dfs(childNode, childCopyNode, nodes);
            } 
            copyNode.neighbors.add(childCopyNode);
        }
    }

    public static void main(String[] args) {
        testSolution2_1();
        testSolution2_2();
        testSolution2_3();
    }

    public static void testSolution2_1() {
        Node n1 = new Node(1); Node n2 = new Node(2);
        Node n3 = new Node(3); Node n4 = new Node(4);
        n1.neighbors.add(n4); n1.neighbors.add(n2); // = new ArrayList<>(){{add(n2);  add(n4);}};
        n2.neighbors.add(n1); n2.neighbors.add(n3); //= new ArrayList<>(){{add(n1); add(n3);}};
        n3.neighbors.add(n2); n3.neighbors.add(n4); //= new ArrayList<>(){{add(n2); add(n4);}};
        n4.neighbors.add(n1); n4.neighbors.add(n3); //= new ArrayList<>(){{add(n1); add(n3);}};
        Solution2 s = new Solution2();
        Node cn1 = s.cloneGraph(n1);
        boolean passed = compareWithClone(n1, cn1);
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_2() {
        Node n1 = new Node(1); 
        Solution2 s = new Solution2();
        Node cn1 = s.cloneGraph(n1);
        boolean passed = compareWithClone(n1, cn1);
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution2_3() {
        Node n1 = null;
        Solution2 s = new Solution2();
        Node cn1 = s.cloneGraph(n1);
        boolean passed = compareWithClone(n1, cn1);
        System.out.println("testSolution_3: " + (passed ? "passed" : "failed"));
    }

    private static boolean compareWithClone(Node node, Node cNode) {
        if (node == null) {
            return cNode == null;
        }

        HashMap<Integer, HashSet<Node>> hood = new HashMap<>();
        dfsHood(node, new HashSet<>(), hood);

        HashMap<Integer, HashSet<Node>> cHood = new HashMap<>();
        dfsHood(cNode, new HashSet<>(), cHood);
        
        boolean passed = true && hood.keySet().size() == cHood.keySet().size();
        for (Integer key : hood.keySet()) {
            HashSet<Node> neighbors = hood.get(key);
            HashSet<Node> cNeighbors = cHood.get(key);

            HashSet<Integer> cVals = new HashSet<>();
            for (Node cNeighb : cNeighbors) {
                cVals.add(cNeighb.val);
            }

            for (Node neighbor : neighbors) {
                if (cNeighbors.contains(neighbor)) {
                    passed = false;
                    break;
                }

                if (!cVals.contains(neighbor.val)) {
                    passed = false;
                    break;
                }
            }
        }
        return passed;
    }

    private static void dfsHood(Node node, HashSet<Node> visited, HashMap<Integer, HashSet<Node>> hood) {
        HashSet<Node> neighbors = new HashSet<>();
        for (Node neightbor : node.neighbors) {
            neighbors.add(neightbor);
            if (!visited.contains(neightbor)) {
                visited.add(neightbor);
                dfsHood(neightbor, visited, hood);
            }
        }
        hood.put(node.val, neighbors);
    }
}
