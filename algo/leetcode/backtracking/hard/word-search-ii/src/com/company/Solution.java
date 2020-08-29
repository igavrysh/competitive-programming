package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private boolean found;

  public List<String> findWords(char[][] board, String[] words) {
    List<String> output = new ArrayList<>();
    for (String word : words) {
      if (exist(board, word)) {
        output.add(word);
      }
    }
    return output;
  }

  public boolean exist(char[][] board, String word) {
    this.found = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        List<String> trajectory = new ArrayList<>();
        trajectory.add(getId(i, j));
        trajectory(board, i, j, word, 0, trajectory);

        if (this.found) {
          return true;
        }
      }
    }
    return this.found;
  }

  private void trajectory(
      char[][] board,
      int i,
      int j,
      String word,
      int wordIndex,
      List<String> traj
  ) {
    if (this.found) {
      return;
    }

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
      return;
    }

    if (board[i][j] != word.charAt(wordIndex)) {
      return;
    }

    if (traj.size() == word.length()) {
      this.found = true;
      return;
    }

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
      return;
    }

    if (board[i][j] == word.charAt(wordIndex)) {
      String newId1 = getId(i + 1, j);
      if (!traj.contains(newId1)) {
        traj.add(newId1);
        trajectory(board, i + 1, j, word, wordIndex + 1, traj);
        traj.remove(traj.size() - 1);
      }

      String newId2 = getId(i - 1, j);
      if (!traj.contains(newId2)) {
        traj.add(newId2);
        trajectory(board, i - 1, j, word, wordIndex + 1, traj);
        traj.remove(traj.size() - 1);
      }

      String newId3 = getId(i, j + 1);
      if (!traj.contains(newId3)) {
        traj.add(newId3);
        trajectory(board, i, j + 1, word, wordIndex + 1, traj);
        traj.remove(traj.size() - 1);
      }

      String newId4 = getId(i, j - 1);
      if (!traj.contains(newId4)) {
        traj.add(newId4);
        trajectory(board, i, j - 1, word, wordIndex + 1, traj);
        traj.remove(traj.size() - 1);
      }
    }
  }

  private String getId(int i, int j) {
    return Integer.toString(i) + "_" + Integer.toString(j);
  }
}