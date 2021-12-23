package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private int[] onStack;
  private int[] marked;
  private List<Integer>[]G;
  private boolean isCycle;

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    onStack = new int[numCourses];
    marked = new int[numCourses];
    G = new ArrayList[numCourses];
    isCycle = false;
    for (int i = 0; i < G.length; i++) {
      G[i] = new ArrayList<>();
    }
    for (int i = 0; i < prerequisites.length; i++) {
      G[prerequisites[i][1]].add(prerequisites[i][0]);
    }
    for (int i = 0; i < numCourses; i++) {
      if (marked[i] == 0) {
        dfs(i);
      }
    }
    return !isCycle;
  }

  private void dfs(int i) {
    if (isCycle) {
      return;
    }
    marked[i] = 1;
    onStack[i] = 1;
    for (Integer nextI : G[i]) {
      if (onStack[nextI] == 1) {
        isCycle = true;
        return;
      }

      if (marked[nextI] == 0) {
        dfs(nextI);
      }
    }
    onStack[i] = 0;
  }

}
