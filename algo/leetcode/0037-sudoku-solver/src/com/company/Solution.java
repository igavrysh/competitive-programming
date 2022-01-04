package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
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
          int num = Character.getNumericValue(board[i][j]);
          rows[i].add(num);
          columns[j].add(num);
          squares[(i/3)*3+j/3].add(num);
        }
      }
    }
    helper(board, rows, columns, squares);
  }

  private boolean helper(
      char[][] board,
      HashSet<Integer>[] rows,
      HashSet<Integer>[] columns,
      HashSet<Integer>[] squares
  ) {
    int N = board.length;

    HashSet<Integer> possibleValues = new HashSet<Integer>(
        Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9}));

    PriorityQueue<Pair> queue = new PriorityQueue<Pair>(
        N*N,

        Comparator.comparingInt(p ->
            -1 * (rows[p.i].size() + columns[p.j].size()
                + squares[p.i/3*3 + p.j/3].size())));

    int emptyPlaces = 0;
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        if (board[i][j] == '.') {
          queue.add(new Pair(i, j));
        }
      }
    }

    if (queue.size() == 0) {
      return true;
    }

    Pair next = queue.poll();
    possibleValues.removeAll(rows[next.i]);
    possibleValues.removeAll(columns[next.j]);
    possibleValues.removeAll(squares[next.i/3*3 + next.j/3]);
    for (Integer e : possibleValues) {
      char c = (char)(e.intValue() + '0');
      board[next.i][next.j] = c;
      rows[next.i].add(e);
      columns[next.j].add(e);
      squares[next.i/3*3 + next.j/3].add(e);
      if (helper(board, rows, columns, squares)) {
        return true;
      }
      board[next.i][next.j] = '.';
      rows[next.i].remove(e);
      columns[next.j].remove(e);
      squares[next.i/3*3 + next.j/3].remove(e);
    }

    return false;
  }
}
