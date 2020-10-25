package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static class Solution {
    public int numGemes(String gemes, String stones) {
      Map<Character, Integer> M = new HashMap<>();
      for (char c : stones.toCharArray()) {
        if (M.get(c) == null) {
          M.put(c, 1);
        } else {
          M.put(c, M.get(c)+1);
        }
      }
      int res = 0;
      for (char g : gemes.toCharArray()) {
        if (M.get(g) != null) {
          res += M.get(g);
        }
      }
      return res;
    }
  }

  public static void main(String[] args) throws Exception {
    File file = new File("input.txt");
    Scanner sc = new Scanner(file);
    String gemes = sc.nextLine();
    String stones = sc.nextLine();
    Solution s = new Solution();
    int output = s.numGemes(gemes, stones);
    PrintWriter pw = new PrintWriter(
        new BufferedWriter(
            new FileWriter("output.txt")));
    pw.println(output);
    pw.flush();
  }
}
