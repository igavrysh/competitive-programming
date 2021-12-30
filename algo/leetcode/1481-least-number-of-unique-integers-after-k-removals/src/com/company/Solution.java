package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    HashMap<Integer, Integer> fq = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      fq.put(arr[i], fq.getOrDefault(arr[i], 0) + 1);
    }
    ArrayList<Integer> q = new ArrayList<>(fq.keySet());
    q.sort((i1, i2) -> {
      return fq.get(i1) - fq.get(i2);
    });

    int t = 0;
    while (k > 0 && t < q.size()) {
      int currFq = fq.get(q.get(t));
      int delta = Math.min(k, currFq);
      k -= delta;
      int newFQ = currFq - delta;
      if (newFQ == 0) {
        fq.remove(q.get(t));
      } else {
        fq.put(q.get(t), newFQ);
      }
      t++;
    }
    return  fq.size();
  }
}
