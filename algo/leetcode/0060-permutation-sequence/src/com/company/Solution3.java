package com.company;

import java.util.ArrayList;

public class Solution3 {
  public String getPermutation(int n, int k) {
    ArrayList<Integer> N = new ArrayList<>();
    int remF = 1;
    for (int i = 1; i <= n; i++) {
      N.add(i);
      remF *= i;
    }
    StringBuilder sb = new StringBuilder();
    backtrack(0, k-1, remF, N, sb);
    return sb.toString();
  }

  private void backtrack(int s, int k, int remFactorial, ArrayList<Integer> N, StringBuilder acc) {
    if (N.size() == 0) {
      return;
    }
    for (int i = 0; i < N.size(); i++) {
      Integer d = N.get(i);
      int branchSize = remFactorial / N.size();
      if (k >= s + branchSize * i && k < s +  branchSize * (i+1)) {
        acc.append(N.get(i));
        N.remove(i);
        backtrack(s + branchSize * i, k, branchSize, N, acc);
        break;
      }
    }
  }
}
