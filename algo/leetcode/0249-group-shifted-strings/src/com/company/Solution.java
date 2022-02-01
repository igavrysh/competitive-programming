package src.com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      String key = key(str);
      List<String> l = map.getOrDefault(key, new ArrayList<>());
      l.add(str);
      map.put(key, l);
    }
    List<List<String>> r = new ArrayList<>();
    for (String key : map.keySet()) {
      r.add(map.get(key));
    }
    return r;
  }

  private String key(String str) {
    StringBuilder sb = new StringBuilder();
    char[] cArr = str.toCharArray();
    for (int i = 1; i < cArr.length; i++) {
      int t = cArr[i] - cArr[i-1];
      if (t < 0) {
        t += 26;
      }
      t %= 26;
      sb.append(Integer.toString(t));
      if (i != cArr.length-1) {
        sb.append("#");
      }
    }
    return sb.toString();
  }
}
