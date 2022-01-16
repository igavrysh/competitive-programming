package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

public class Solution {
  public int minJumps(int[] arr) {
    if (arr.length <= 1) {
      return 0;
    }
    HashMap<Integer, List<Integer>> M = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      List<Integer> next =  M.getOrDefault(arr[i], new ArrayList<>());
      next.add(i);
      M.put(arr[i], next);
    }
    return bfs(arr, M, 0, arr.length-1, arr.length);
  }

  private int bfs(int[] arr, HashMap<Integer, List<Integer>> M, int s, int e, int N) {
    // pair consists of vertex index and distance to it from start point
    Queue<Pair<Integer, Integer>> Q = new LinkedList<>();
    Q.add(new Pair<>(s, 0));
    boolean[] visited = new boolean[N];

    while (!Q.isEmpty()) {
      Pair<Integer, Integer> p = Q.poll();
      List<Integer> next = M.get(arr[p.getKey()]);
      if (p.getKey() > 0) {
        next.add(p.getKey()-1);
      }
      if (p.getKey() < N-1) {
        next.add(p.getKey()+1);
      }
      for (Integer n : next) {
        if (n == e) {
          return p.getValue()+1;
        }
        if (visited[n] == false) {
          Q.offer(new Pair<>(n, p.getValue()+1));
          visited[n] = true;
        }
      }
    }
    return -1;
  }
}
