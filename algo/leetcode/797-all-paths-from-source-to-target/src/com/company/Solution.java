package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> output = new ArrayList<>();
    if (graph.length == 0) {
      return output;
    }
    List<Integer> p = new ArrayList<>();
    p.add(0);
    DAG(0, graph, p, output);
    return output;
  }

  private void DAG(int currPos, int[][] G, List<Integer> p, List<List<Integer>> result) {
    for (int next : G[currPos]) {
      p.add(next);
      if (next == G.length-1) {
        result.add(new ArrayList<>(p));
      } else {
        DAG(next, G, p, result);
      }
      p.remove(p.size()-1);
    }
  }
}