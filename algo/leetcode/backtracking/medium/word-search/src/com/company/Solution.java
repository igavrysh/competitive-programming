package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public boolean exist(char[][] board, String word) {
    Boolean found = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        trajectory(board, i, j, word, 0, new ArrayList<>(), found);

        if (found) {
          return true;
        }
      }
    }

    return false;
  }

  private void trajectory(
      char[][] board,
      int i,
      int j,
      String word,
      int wordIndex,
      List<String> traj,
      Boolean found) {
    if (traj.size() == word.length()) {
      found = true;
      return;
    }

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
      return;
    }



    if (board[i][j] == word.charAt(wordIndex)) {
      traj.add(Integer.toString(i) + "_" + Integer.toString(j));
      trajectory(board, i + 1, j, word, wordIndex + 1, traj, found);
      traj.remove(traj.size() - 1);

      traj.add(Integer.toString(i) + "_" + Integer.toString(j));
      trajectory(board, i - 1, j, word, wordIndex + 1, traj, found);
      traj.remove(traj.size() - 1);

      traj.add(Integer.toString(i) + "_" + Integer.toString(j));
      trajectory(board, i, j + 1, word, wordIndex + 1, traj, found);
      traj.remove(traj.size() - 1);

      traj.add(Integer.toString(i) + "_" + Integer.toString(j));
      trajectory(board, i, j - 1, word, wordIndex + 1, traj, found);
      traj.remove(traj.size() - 1);
    }
  }
}
