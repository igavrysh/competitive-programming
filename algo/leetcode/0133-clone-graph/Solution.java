import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node proxy = new Node(-1, new ArrayList<>() {{add(node);}});
        Node cProxy = new Node(-1);
        dfs(proxy, cProxy, new HashMap<>(){{put(proxy.val, proxy);}}, 
            new HashMap<>(){{put(cProxy.val, cProxy);}});
        Node cNode = cProxy.neighbors.get(0);
        for (int i = 0; i < cNode.neighbors.size(); i++) {
            if (cNode.neighbors.get(i) == cProxy) {
                cNode.neighbors.remove(i);
                break;
            }
        }
        return cNode;
    }

    private void dfs(Node node, Node cNode, HashMap<Integer, Node> visNodes, 
        HashMap<Integer, Node> visCNodes) {
        for (Node neighbor : node.neighbors) {
            if (!visNodes.keySet().contains(neighbor.val)) {
                Node cNeighbor = new Node(neighbor.val);
                cNode.neighbors.add(cNeighbor);
                visNodes.put(neighbor.val, neighbor);
                visCNodes.put(cNeighbor.val, cNeighbor);
                dfs(neighbor, cNeighbor, visNodes, visCNodes);
            } else {
                cNode.neighbors.add(visCNodes.get(neighbor.val));
            }
        }
    }

    public static void main(String[] args) {
        testSolution_1();
        testSolution_2();
        testSolution_3();
    }

    public static void testSolution_1() {
        Node n1 = new Node(1); Node n2 = new Node(2);
        Node n3 = new Node(3); Node n4 = new Node(4);
        n1.neighbors.add(n4); n1.neighbors.add(n2); // = new ArrayList<>(){{add(n2);  add(n4);}};
        n2.neighbors.add(n1); n2.neighbors.add(n3); //= new ArrayList<>(){{add(n1); add(n3);}};
        n3.neighbors.add(n2); n3.neighbors.add(n4); //= new ArrayList<>(){{add(n2); add(n4);}};
        n4.neighbors.add(n1); n4.neighbors.add(n3); //= new ArrayList<>(){{add(n1); add(n3);}};
        Solution s = new Solution();
        Node cn1 = s.cloneGraph(n1);
        boolean passed = compareWithClone(n1, cn1);
        System.out.println("testSolution_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_2() {
        Node n1 = new Node(1); 
        Solution s = new Solution();
        Node cn1 = s.cloneGraph(n1);
        boolean passed = compareWithClone(n1, cn1);
        System.out.println("testSolution_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolution_3() {
        Node n1 = null;
        Solution s = new Solution();
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