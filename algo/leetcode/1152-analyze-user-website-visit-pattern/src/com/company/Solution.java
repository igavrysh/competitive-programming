package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javafx.util.Pair;

public class Solution {
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    HashMap<String, ArrayList<Pair<Integer, String>>> H = new HashMap<>();

    for (int i = 0; i < username.length; i++) {
      ArrayList<Pair<Integer, String>> l = H.getOrDefault(username[i], new ArrayList<>());
      l.add(new Pair<>(timestamp[i], website[i]));
      H.put(username[i], l);
    }

    HashMap<String, Integer> fq = new HashMap<>();

    String result = null;

    for (String u : H.keySet()) {
      HashSet<String> set = new HashSet<>();
      ArrayList<Pair<Integer, String>> l = H.get(u);
      l.sort((Pair<Integer, String> pair1, Pair<Integer, String> pair2) -> {
        return pair1.getKey() - pair2.getKey();
      });

      for (int i = 0; i < l.size()-2; i++) {
        for (int j = i+1; j < l.size()-1; j++) {
          for (int s = j+1; s < l.size(); s++) {
            Pair<Integer, String> pi = l.get(i);
            Pair<Integer, String> pj = l.get(j);
            Pair<Integer, String> ps = l.get(s);

            StringBuilder sb = new StringBuilder();
            sb.append(pi.getValue());
            sb.append(" ");
            sb.append(pj.getValue());
            sb.append(" ");
            sb.append(ps.getValue());
            String key = sb.toString();
            if (!set.contains(key)) {
              fq.put(key, fq.getOrDefault(key, 0) + 1);
              set.add(key);
            }

            if (result == null || fq.get(result) < fq.get(key) || (fq.get(result) == fq.get(key) && result.compareTo(key) > 0)) {
              result = key;
            }
          }
        }
      }
    }

    String[] resArr = result.split(" ");
    List<String> output = new ArrayList<>();
    for (String p : resArr) {
      output.add(p);
    }
    return output;
  }
}
