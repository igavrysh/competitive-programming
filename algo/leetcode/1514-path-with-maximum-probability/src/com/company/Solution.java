package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
  private class Pair {
    int v;
    double w;
    Pair(int v, double w) {
      this.v = v;
      this.w = w;
    }
  }

  private class Path {
    int v;
    double prob;
    Path(int v, double prob) {
      this.v = v;
      this.prob = prob;
    }
  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    List<Pair>[] G = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      G[i] = new ArrayList<>();
    }
    for (int i = 0; i < edges.length; i++) {
      int[] e = edges[i];
      double w = succProb[i];
      G[e[0]].add(new Pair(e[1], w));
      G[e[1]].add(new Pair(e[0], w));
    }
    Double[] prob = new Double[n];
    prob[start] = 1.0;
    PriorityQueue<Path> q = new PriorityQueue<>((Path a, Path b) -> b.prob - a.prob >= 0 ? 1 : -1);
    q.offer(new Path(start, 1.0));
    while (!q.isEmpty()) {
      Path v = q.poll();
      if (v.v == end) {
        return v.prob;
      }
      for (Pair nbr : G[v.v]) {
        double nbrProb = prob[v.v] * nbr.w;
        if (prob[nbr.v] == null || prob[nbr.v] < nbrProb) {
          prob[nbr.v] = nbrProb;
          q.offer(new Path(nbr.v, nbrProb));
        }
      }
    }
    return 0;
  }
}
