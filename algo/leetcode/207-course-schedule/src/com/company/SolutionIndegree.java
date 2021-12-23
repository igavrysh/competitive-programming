package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionIndegree {

  class GNode {
    int i = 0;
    int inDegrees = 0;
    List<Integer> nodes = new ArrayList<>();
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int totalEdges = prerequisites.length;
    HashMap<Integer, GNode> G = new HashMap<>();

    for (int i = 0; i < prerequisites.length; i++) {
      GNode from = getOrCreate(G, prerequisites[i][1]);
      GNode to = getOrCreate(G, prerequisites[i][0]);
      from.nodes.add(prerequisites[i][0]);
      to.inDegrees += 1;
    }

    Queue<Integer> zeroIndegrees = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      GNode node = getOrCreate(G, i);
      if (node.inDegrees == 0) {
        zeroIndegrees.offer(i);
      }
    }

    int edgesRemoved = 0;
    while (zeroIndegrees.size() > 0) {
      int n = zeroIndegrees.poll();
      GNode node = getOrCreate(G, n);
      for (Integer i : node.nodes) {
        GNode nNode = getOrCreate(G, i);
        nNode.inDegrees -= 1;
        edgesRemoved += 1;
        if (nNode.inDegrees == 0) {
          zeroIndegrees.offer(nNode.i);
        }
      }
    }

    if (totalEdges != edgesRemoved) {
      return false;
    }
    return true;

  }

  private GNode getOrCreate(HashMap<Integer, GNode> G, int i) {
    if (G.get(i) == null) {
      GNode node = new GNode();
      node.i = i;
      G.put(i, node);
      return node;
    }
    return G.get(i);
  }
}
