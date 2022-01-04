package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  private boolean[] marked;
  private boolean[] onStack;
  private boolean isCycle = false;
  private Stack<Integer> reversePost;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] G = new ArrayList[numCourses];
    reversePost = new Stack<>();
    marked = new boolean[numCourses];
    onStack = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      G[i] = new ArrayList<>();
    }

    for (int i = 0; i < prerequisites.length; i++) {
      G[prerequisites[i][1]].add(prerequisites[i][0]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (!marked[i]) {
        dfs(i, G);
      }
    }

    if (isCycle) {
      return new int[0];
    }

    int[] output = new int[numCourses];
    int S = reversePost.size();
    for (int i = 0; i < S; i++) {
      output[i] = reversePost.pop();
    }
    return output;
  }

  private void dfs(int v, List<Integer>[] G) {
    List<Integer> adj = G[v];
    marked[v] = true;
    onStack[v] = true;

    for (int i = 0; i < adj.size(); i++) {
      if (onStack[adj.get(i)]) {
        isCycle = true;
        return;
      }
      if (!marked[adj.get(i)]) {
        dfs(adj.get(i), G);
      }
    }
    reversePost.push(v);
    onStack[v] = false;
  }
}
