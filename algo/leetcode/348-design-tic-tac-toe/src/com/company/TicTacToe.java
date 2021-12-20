package com.company;

class TicTacToe {

  int[] cols;
  int[] rows;
  int diagonal;
  int antidiagonal;
  int n;

  public TicTacToe(int n) {
    this.n = n;
    cols = new int[n];
    rows = new int[n];
    for (int i = 0; i < n; i++) {
      cols[i] = 0;
      rows[i] = 0;
    }
    diagonal = 0;
    antidiagonal = 0;
  }

  public int move(int row, int col, int player) {
    int sign = 1;
    if (player == 2) {
      sign = -1;
    }
    rows[col] += sign * 1;
    cols[row] += sign * 1;
    if (row == col) {
      diagonal += sign * 1;
    }
    if (row == n-col-1) {
      antidiagonal += sign * 1;
    }

    if (rows[col] == n || cols[row] == n || antidiagonal == n || diagonal == n) {
      return 1;
    } else if (rows[col] == -n || cols[row] == -n || antidiagonal == -n || diagonal == -n) {
      return 2;
    }
    return 0;
  }
}