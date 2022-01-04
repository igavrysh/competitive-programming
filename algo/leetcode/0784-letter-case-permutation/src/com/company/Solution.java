package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public List<String> letterCasePermutation(String S) {
    List<String> output = new ArrayList<>();
    List<StringBuilder> sbs = new ArrayList<>();
    sbs.add(new StringBuilder());
    for (char s : S.toCharArray()) {
      List<StringBuilder> sbs2 = new ArrayList<>();
      for (StringBuilder sb : sbs) {
        if (Character.isLetter(s)) {
          StringBuilder sb2 = new StringBuilder(sb);
          sb2.append(Character.toLowerCase(s));
          sb.append(Character.toUpperCase(s));
          sbs2.add(sb2);
        } else {
          sb.append(s);
        }
      }
      sbs.addAll(sbs2);
    }
    return sbs
        .stream()
        .map(StringBuilder::toString)
        .collect(Collectors.toList());
  }
}
