import java.util.HashSet;
import java.util.HashMap;

public class Solution {
    public int getTaskId(int[][] connections, int targetServer) {
        HashMap<Integer, HashSet<Integer>> G = buildGraph(connections);
        int n = G.size();
        for (Integer k : G.keySet()) {
            HashMap<Integer, Integer> mapping = new HashMap<>();
            HashSet<Integer> serversUsed = new HashSet<>();
            serversUsed.add(k);
            if (DFS(k, 0, n-1, G, mapping, serversUsed)) {
                int s = 1;
                return mapping.get(targetServer);
            }
        }
        return -1;
    }

    private HashMap<Integer, HashSet<Integer>> buildGraph(int[][] connections) {
        HashMap<Integer, HashSet<Integer>> G = new HashMap<>();
        for (int[] conn : connections) {
            HashSet<Integer> set = G.getOrDefault(conn[0], new HashSet<>());
            set.add(conn[1]);
            G.put(conn[0], set);
            HashSet<Integer> backSet = G.getOrDefault(conn[1], new HashSet<>());
            G.put(conn[1], backSet);
        }
        return G;
    }

    private boolean DFS(int server, int taskS, int taskE, HashMap<Integer, HashSet<Integer>> G,
        HashMap<Integer, Integer> mapping, HashSet<Integer> serversUsed
    ) {
        if (taskS == taskE) {
            mapping.put(server, taskS);
            return true;
        }
        HashSet<Integer> nghbrs = G.get(server);
        for (Integer nghbr : nghbrs) {
            if (nghbr == server) {
                continue;
            }
            if (serversUsed.contains(nghbr)) {
                continue;
            }
            serversUsed.add(nghbr);
            int newTaskS = taskS + (taskE-taskS+1)/2;
            if (DFS(nghbr, newTaskS, taskE, G, mapping, serversUsed) 
                && DFS(server, taskS, newTaskS-1, G, mapping, serversUsed)
            ) {
                return true;
            } 
            serversUsed.remove(nghbr);
        }
        return false;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        int[][] connections = {{101, 42}};
        Solution sol = new Solution();
        boolean passed = true;
        passed = passed && sol.getTaskId(connections, 101) == 0;
        passed = passed && sol.getTaskId(connections, 42) == 1;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    private static void test2() {
        int[][] connections = {{42, 101}};
        Solution sol = new Solution();
        boolean passed = true;
        passed = passed && sol.getTaskId(connections, 101) == 1;
        passed = passed && sol.getTaskId(connections, 42) == 0;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    private static void test3() {
        int[][] connections = {
            {0,1}, {0,4}, {0,6},
            {1,5}, {1,7},
            {4,2},
            {5,3}   
        };
        Solution sol = new Solution();
        boolean passed = true;
        passed = passed && sol.getTaskId(connections, 0) == 0;
        passed = passed && sol.getTaskId(connections, 1) == 4;
        passed = passed && sol.getTaskId(connections, 2) == 3;
        passed = passed && sol.getTaskId(connections, 3) == 7;
        passed = passed && sol.getTaskId(connections, 4) == 2;
        passed = passed && sol.getTaskId(connections, 5) == 6;
        passed = passed && sol.getTaskId(connections, 6) == 1;
        passed = passed && sol.getTaskId(connections, 7) == 5;

        System.out.println("test3: " + (passed ? "passed" : "failed"));
    }

    private static void test4() {
        // equals to test3 but server 0, and 7 swapped so now server 7 has 3 connections
        // and server 0 has 0 connections
        int[][] connections = {
            {7,1}, {7,4}, {7,6},
            {1,5}, {1,0},
            {4,2},
            {5,3}   
        };
        Solution sol = new Solution();
        boolean passed = true;
        passed = passed && sol.getTaskId(connections, 0) == 5;
        passed = passed && sol.getTaskId(connections, 1) == 4;
        passed = passed && sol.getTaskId(connections, 2) == 3;
        passed = passed && sol.getTaskId(connections, 3) == 7;
        passed = passed && sol.getTaskId(connections, 4) == 2;
        passed = passed && sol.getTaskId(connections, 5) == 6;
        passed = passed && sol.getTaskId(connections, 6) == 1;
        passed = passed && sol.getTaskId(connections, 7) == 0;
        System.out.println("test4: " + (passed ? "passed" : "failed"));
    }

    private static void test5() {
        // equals to test3 but server 0, and 7 swapped so now server 7 has 3 connections
        // and server 0 has 0 connections
        int[][] connections = {
            {0,1},{1,2},{2,3}  
        };
        Solution sol = new Solution();
        boolean passed = true;
        passed = passed && sol.getTaskId(connections, 0) == -1;
        passed = passed && sol.getTaskId(connections, 1) == -1;
        passed = passed && sol.getTaskId(connections, 2) == -1;
        passed = passed && sol.getTaskId(connections, 3) == -1;
        System.out.println("test5: " + (passed ? "passed" : "failed"));
    }
}
