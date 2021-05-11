package com.company;

import java.util.Stack;

public class Solution2 {
  public String getPermutation(int n, int k) {
    int[] num = new int[n];
    for (int i = 0; i < num.length; i++) {
      num[i] = i+1;
    }
    int t = 1;
    while (t < k) {
      for (int i = num.length-2; i >= 0; i--) {
        for (int j = num.length-1; j > i; j--) {
          if (num[i] < num[j]) {
            int valueToPaste = num[i];
            num[i] = num[j];
            Stack<Integer> stack = new Stack<>();
            for (int z = i+1; z < num.length; z++) {
              if (z == j) {
                continue;
              }
              if (valueToPaste > num[z]) {
                stack.push(valueToPaste);
                valueToPaste = -1;
              }
              stack.push(num[z]);
            }
            if (valueToPaste != -1) {
              stack.push(valueToPaste);
            }
            int z = i+1;
            while(stack.size() > 0) {
              num[z] = stack.pop();
              z++;
            }
            i = -1;
            j = -1;
          }
        }
      }
      t++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < num.length; i++) {
      sb.append(String.valueOf(num[i]));
    }
    return sb.toString();
  }

}
