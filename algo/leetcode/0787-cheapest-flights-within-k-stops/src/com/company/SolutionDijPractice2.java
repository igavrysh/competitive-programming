package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SolutionDijPractice2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Integer[]>[] G = new ArrayList[n];
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            ArrayList<Integer[]> nghbrs = G[from];
            if (nghbrs == null) {
                nghbrs = new ArrayList<>();
            }
            nghbrs.add(new Integer[] {to, cost});
            G[from] = nghbrs;
        }

        Integer[] stops = new Integer[n];
        // node id, dist to node, stops to reach
        PriorityQueue<int[]> PQ = new PriorityQueue<>((int[] v1, int[] v2) -> v1[1] - v2[1]);
        PQ.offer(new int[]{src, 0, 0});
        while (PQ.size() > 0) {
            int[] v = PQ.poll();
            int currV = v[0];
            int currCost = v[1];
            int currStops = v[2];
            if (v[0] == dst) {
                return currCost;
            }
            if (currStops == k+1) {
                continue;
            }
            if (stops[currV] != null && stops[currV] <= currStops) {
                continue;
            } 
            if (stops[currV] == null) {
                stops[currV] = currStops;
            }

            ArrayList<Integer[]> nghbrs = G[currV];
            if (nghbrs == null) {
                continue;
            }
            for (Integer[] nghbr : nghbrs) {
                PQ.offer(new int[]{nghbr[0], currCost + nghbr[1], currStops + 1});
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        testSolutionDijPractice2_1();
        testSolutionDijPractice2_2();
        testSolutionDijPractice2_3();
    }

    public static void testSolutionDijPractice2_1() {
        int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        SolutionDijPractice2 s = new SolutionDijPractice2();
        int output = s.findCheapestPrice(3, edges, 0, 2, 1);
        boolean passed = output == 200;
        System.out.println("testSolutionDijPractice2_1: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDijPractice2_2() {
        int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        SolutionDijPractice2 s = new SolutionDijPractice2();
        int output = s.findCheapestPrice(3, edges, 0, 2, 0);
        boolean passed = output == 500;
        System.out.println("testSolutionDijPractice2_2: " + (passed ? "passed" : "failed"));
    }

    public static void testSolutionDijPractice2_3() {
        int[][] edges = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        SolutionDijPractice2 s = new SolutionDijPractice2();
        int output = s.findCheapestPrice(4, edges, 0, 3, 1);
        boolean passed = output == 6;
        System.out.println("testSolutionDijPractice2_3: " + (passed ? "passed" : "failed"));
    }
}
