package com.company;

public class Solution {

  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }
    int top = -1;
    int N = arr.length;

    for (int i = 1; i < arr.length-1; i++) {
      if (arr[i-1]<arr[i] && arr[i+1]<arr[i]) {
        top = i;
      } else if (top == -1) {
        if (arr[i]<=arr[i-1]) {
          return false;
        }
      } else if (top != -1) {
        if (arr[i+1]>=arr[i]) {
          return false;
        }
      }
    }
    return top != -1;
  }
}
