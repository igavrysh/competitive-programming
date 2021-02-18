package com.company;

import java.util.HashSet;

public class Solution {

  private class FQ {
    public int row;
    public int column;
    public int sq;
    public FQ(int row, int column, int sq) {
      this.row = row;
      this.column = column;
      this.sq = sq;
    }
  }

  public void solveSudoku(char[][] board) {
    int N = board.length;
    HashSet<Integer>[] rows = new HashSet[N];
    HashSet<Integer>[] columns = new HashSet[N];
    HashSet<Integer>[] squares = new HashSet[N];

    for (int i = 0; i < N; i++) {
      rows[i] = new HashSet<>();
      columns[i] = new HashSet<>();
      squares[i] = new HashSet<>();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] != '.') {
          rows[i].add((int)board[i][j]);
          columns[j].add((int)board[i][j]);
          squares[(i/3)*3+j/3].add((int)board[i][j]);
        }
      }
    }



    int maxFq = 0;
    int nextR, nextC, nextSq;
    for (int r = 0; r < rows.length; r++) {
      for (int c = 0; c < columns.length; c++) {
        for (int sq = 0; sq < squares.length; sq++) {
          if (rows[r].size() + columns[c].size() + squares[sq].size() > maxFq) {
            maxFq = rows[r].size() + columns[c].size() + squares[sq].size();
            nextR = r;
            nextC = c;
            nextSq = sq;
          }
        }
      }
    }
  }

  private void helper() {


  }


}
