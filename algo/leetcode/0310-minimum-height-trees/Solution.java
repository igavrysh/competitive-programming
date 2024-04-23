import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashSet<Integer>[] G = new HashSet[n];
        for (int i = 0; i < n; i++) {
            G[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            G[edges[i][0]].add(edges[i][1]);
            G[edges[i][1]].add(edges[i][0]);
        }
        int[] degrees = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> nghbrs = G[i];
            if (nghbrs.size() == 1) {
                leaves.offer(i);
            }
            degrees[i] = nghbrs.size();
        }

        while (n > 2) {
            int level = leaves.size();
        
            for (int l = 0; l < level; l++) {
                int leaf = leaves.poll();
                n--;
                HashSet<Integer> nghbrs = G[leaf];
                for (int ngbr : nghbrs) {
                    degrees[ngbr]--;
                    if (degrees[ngbr] == 1) {
                        leaves.add(ngbr);
                    }
                }
            }
        }
        List<Integer> output = new ArrayList<>();
        while (!leaves.isEmpty()) {
            output.add(leaves.poll());
        }
        return output;
    }

    public static void main(String[] args) {
        test3();
        test2();
    }

    public static void test3() {
        int n = 3;
        int[][] edges = {{0,1},{1,2}};
        List<Integer> expOutput = new ArrayList<>() {{ add(1); }};
        HashSet<Integer> expOutputS = new HashSet<>();
        for (Integer i : expOutput) {
            expOutputS.add(i);
        }
        Solution sol = new Solution();
        List<Integer> output = sol.findMinHeightTrees(n, edges);
        HashSet<Integer> outputS = new HashSet<>();
        for (Integer i : output) {
            outputS.add(i);
        }
        boolean passed = outputS.equals(expOutputS);
        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> expOutput = new ArrayList<>() {{ add(3); add(4); }};
        HashSet<Integer> expOutputS = new HashSet<>();
        for (Integer i : expOutput) {
            expOutputS.add(i);
        }
        Solution sol = new Solution();
        List<Integer> output = sol.findMinHeightTrees(n, edges);
        HashSet<Integer> outputS = new HashSet<>();
        for (Integer i : output) {
            outputS.add(i);
        }
        boolean passed = outputS.equals(expOutputS);
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}