package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import javafx.util.Pair;

public class Solution {
  public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
    TreeSet<Integer> free = new TreeSet<>();
    int maxWork = 0;
    for (int i = 0; i < k; i++) {
      Integer serverIdx = i;
      free.add(serverIdx);
    }
    int[] fq = new int[k];


    // key: server id, value: time server becomes available
    PriorityQueue<Pair<Integer, Integer>> busy
        = new PriorityQueue<>(
            (Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) -> {
              return p1.getValue() - p2.getValue();
            });

    int N = arrival.length;
    for (int i = 0; i < N; i++) {
      // add all out of work servers at moment arrival[i] to free
      while (!busy.isEmpty() && busy.peek().getValue() <= arrival[i]) {
        Pair<Integer, Integer> avail = busy.poll();
        free.add(avail.getKey());
      }

      // get available server
      Integer server = free.ceiling(i%k);
      if (server == null && !free.isEmpty()) {
        server = free.first();
      }

      // if out of work server is found load it with current task, update task counters and
      // free TreeSet
      if (server != null) {
        busy.add(new Pair<>(server, arrival[i]+load[i]));
        free.remove(server);
        fq[server] = fq[server]+1;
        if (maxWork < fq[server]) {
          maxWork = fq[server];
        }
      }
    }

    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < fq.length; i++) {
      if (fq[i] == maxWork) {
        res.add(i);
      }
    }
    return res;
  }
}
