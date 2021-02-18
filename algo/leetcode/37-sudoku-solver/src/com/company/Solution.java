package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

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

  class Pair {
    public int i;
    public int j;
    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
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

    HashSet<Integer> possibleValues = new HashSet<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9}));

    PriorityQueue<Pair> queue = new PriorityQueue<Pair>(
            N*N,
            Comparator.comparingInt(p -> rows[p.i].size() + columns[p.j].size() + squares[p.i / 3 * 3 + p.j / 3].size()));
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        if (board[i][j] == '.') {
          queue.add(new Pair(i, j));
        }
      }
    }

    if (queue.size() == 0) {
    }

    Pair next = queue.poll();
    possibleValues.removeAll(rows[next.i]);
    possibleValues.removeAll(columns[next.j]);
    possibleValues.removeAll(squares[next.i/3*3 + next.j/3]);
    for (Integer e : possibleValues) {
      board[next.i][next.j] = (char)e.intValue();
    }
  }

  private boolean helper() {
    return false;
  }
}
