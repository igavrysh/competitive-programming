package com.company;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class SolutionExceededTimeLimit {

  public int sumSubarrayMins(int[] arr) {
    Integer output = 0;
    List<Pair<Integer, Integer>> stack = new ArrayList<>();
    stack.add(0, new Pair<>(arr[0], 0));
    output += arr[0];
    for (int i = 1; i < arr.length; i++) {
      while (stack.size() > 0 && stack.get(stack.size()-1).getKey() > arr[i]) {
        stack.remove(stack.size()-1);
      }
      stack.add(stack.size(), new Pair<>(arr[i], i));

      for (int j = stack.size()-1; j >= 0; j--) {
        Pair<Integer, Integer> pairJ = stack.get(j);
        if (j > 0) {
          Pair<Integer, Integer> pairPrevJ = stack.get(j-1);
          output += pairJ.getKey() * (pairJ.getValue() - pairPrevJ.getValue());
        } else {
          output += pairJ.getKey() * (pairJ.getValue() + 1);
        }
      }
    }
    return output % (int)(Math.pow(10, 9) + 7);
  }

}
