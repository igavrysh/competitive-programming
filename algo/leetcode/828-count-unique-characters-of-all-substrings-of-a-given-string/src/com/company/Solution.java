package com.company;

public class Solution {

  public int uniqueLetterString(String s) {
    int N = s.length();
    int[][] fq = new int[26][2];
    int[] DP = new int[N];
    DP[0] = 1;
    fq[s.charAt(0)-'A'] = new int[]{0,1};
    int result = DP[0];
    for (int i = 1; i < N; i++) {
      int cidx = s.charAt(i)-'A';
      DP[i] = DP[i-1] + i+1;
      if (fq[cidx][0] == 0 && fq[cidx][1] == 0) {
        fq[cidx] = new int[]{0,i+1};
      } else {
        DP[i] = DP[i] - fq[cidx][0] - 2 * fq[cidx][1];
        int[] newVal = new int[]{
            fq[cidx][0]+fq[cidx][1],
            i+1 - (fq[cidx][0]+fq[cidx][1])
        };
        fq[cidx] = newVal;
      }
      result += DP[i];
    }
    return result;
  }
}
