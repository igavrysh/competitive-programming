package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int left = 0;
    int right = people.length - 1;
    int output = 0;

    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        left++;
        right--;
        output++;
      } else {
        right--;
        output++;
      }
    }
    return  output;
  }

}
