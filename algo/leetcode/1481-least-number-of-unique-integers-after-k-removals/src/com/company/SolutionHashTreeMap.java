package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SolutionHashTreeMap {
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int a : arr) {
      count.put(a, 1 + count.getOrDefault(a, 0));
    }
    int remaining = count.size();
    TreeMap<Integer, Integer> occurrenceCount = new TreeMap<>();
    for (int v : count.values()) {
      occurrenceCount.put(v, 1 + occurrenceCount.getOrDefault(v, 0));
    }
    while (k > 0) {
      Map.Entry<Integer, Integer> entry = occurrenceCount.pollFirstEntry();
      if (k - entry.getKey() * entry.getValue() >= 0) {
        k -= entry.getKey() * entry.getValue();
        remaining -= entry.getValue();
      } else {
        return remaining - k / entry.getKey();
      }
    }
    return remaining;
  }
}
