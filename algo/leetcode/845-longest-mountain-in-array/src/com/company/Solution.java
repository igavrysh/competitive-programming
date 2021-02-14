package com.company;

public class Solution {
  public int longestMountain(int[] arr) {
    int startPoint = -1;
    int output = 0;
    int i = 1;
    while (i < arr.length-1) {
      // /
      if (arr[i] > arr[i-1] && arr[i+1] > arr[i]) {
        if (i-1 == 0 || startPoint == -1) {
          startPoint = i-1;
        }
      }

      // V
      if (arr[i] < arr[i-1] && arr[i+1] > arr[i]) {

        if (i-1 == 0 || startPoint == -1) {
          startPoint = i;
        } else {
          if (startPoint != -1) {
            if (i-startPoint+1 > output) {
              output = i - startPoint + 1;
            }
          }
          startPoint = i;
        }
      }

      // \
      if (arr[i] < arr[i-1] && arr[i+1] < arr[i]) {
        if (i+1 == arr.length-1) {
          if (startPoint != -1) {
            if (i+1-startPoint+1 > output) {
              output = i+1-startPoint+1;
            }
          }
        }
      }

      // A
      if (arr[i] > arr[i-1] && arr[i+1] < arr[i]) {
        if (arr.length == 3) {
          output = 3;
        }

        if (i-1 == 0) {
          startPoint = 0;
        }

        if (i+1 == arr.length-1) {
          if (startPoint != -1) {
            if (i+1-startPoint+1 > output) {
              output = i+1-startPoint+1;
            }
          }
        }
      }

      // /-
      if (arr[i] > arr[i-1] && arr[i] == arr[i+1]) {
        startPoint = -1;
      }

      // \_
      if (arr[i] < arr[i-1] && arr[i] == arr[i+1]) {
        if (startPoint != -1) {
          if (i-startPoint+1 > output) {
            output = i-startPoint+1;
          }
        }
        startPoint = -1;
      }

      // -\
      if (arr[i] == arr[i-1] && arr[i] > arr[i+1]) {
        startPoint = -1;
      }

      // _/
      if (arr[i] == arr[i-1] && arr[i] < arr[i+1]) {
        startPoint = i;
      }
      i++;
    }

    return output;
  }
}
