package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
  public List<List<String>> solveNQueens(int n) {
    int[][] B = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        B[i][j] = EMPTY;
      }
    }
    List<List<String>> output = new ArrayList<>();
    check(1, n, B, output, new HashSet<>());
    return output;
  }

  private static final int EMPTY = 99;
  private static final int QUEEN = 100;

  public int hash(int[][] B) {
    int[] tmp = new int[B.length];
    int idx = 0;
    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B.length; j++) {
        if (B[i][j] == QUEEN) {
          tmp[idx] = i * B.length + j;
          idx++;
        }
      }
    }
    return Arrays.hashCode(tmp);
  }


  private void check(int currQ, int n, int[][] B, List<List<String>> output, HashSet<Integer> outputHashes) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (B[i][j] == EMPTY) {
          B[i][j] = QUEEN;

          if (currQ == n) {
            int hashB = hash(B);

            if (!outputHashes.contains(hashB)) {

              List<String> currBoard = new ArrayList<>();
              for (int i1 = 0; i1 < n; i1++) {
                StringBuilder sb = new StringBuilder();
                for (int j1 = 0; j1 < n; j1++) {
                  if (B[i1][j1] == QUEEN) {
                    sb.append('Q');
                  } else {
                    sb.append('.');
                  }
                }
                currBoard.add(sb.toString());
              }

              output.add(currBoard);
              outputHashes.add(hashB);
            }
            B[i][j] = EMPTY;
            
            continue;
          }

          for (int s = 0; s < n; s++) {
            if (B[i][s] == EMPTY) {
              B[i][s] = currQ;
            }
            if (B[s][j] == EMPTY) {
              B[s][j] = currQ;
            }
            if (i + s < n && j + s < n && B[i + s][j + s] == EMPTY) {
              B[i + s][j + s] = currQ;
            }
            if (i - s >= 0 && j + s < n && B[i - s][j + s] == EMPTY) {
              B[i - s][j + s] = currQ;
            }
            if (i + s < n && j - s >= 0 && B[i + s][j - s] == EMPTY) {
              B[i + s][j - s] = currQ;
            }
            if (i - s >= 0 && j - s >= 0 && B[i - s][j - s] == EMPTY) {
              B[i - s][j - s] = currQ;
            }
          }
          check(currQ+1, n, B, output, outputHashes);
          B[i][j] = EMPTY;
          for (int s = 0; s < n; s++) {
            if (B[i][s] == currQ) {
              B[i][s] = EMPTY;
            }
            if (B[s][j] == currQ) {
              B[s][j] = EMPTY;
            }
            if (i + s < n && j + s < n && B[i + s][j + s] == currQ) {
              B[i + s][j + s] = EMPTY;
            }
            if (i - s >= 0 && j + s < n && B[i - s][j + s] == currQ) {
              B[i - s][j + s] = EMPTY;
            }
            if (i + s < n && j - s >= 0 && B[i + s][j - s] == currQ) {
              B[i + s][j - s] = EMPTY;
            }
            if (i - s >= 0 && j - s >= 0 && B[i - s][j - s] == currQ) {
              B[i - s][j - s] = EMPTY;
            }
          }
        }
      }
    }
  }
}
