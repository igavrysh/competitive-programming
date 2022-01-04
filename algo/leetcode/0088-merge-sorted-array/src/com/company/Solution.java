package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    Queue<Integer> Q = new LinkedList<>();
    int i = 0;
    int j = 0;
    while (i < m+n) {
      Integer num1 = i < m ? nums1[i] : null;
      Integer num2 = j < n ? nums2[j] : null;
      Integer numQ = Q.peek();
      if (num1!=null && (num2==null || num1<=num2) && (numQ==null || num1<=numQ)) {
        i++;
      } else if (num2!=null && (num1==null || num2<=num1) && (numQ==null || num2<=numQ)) {
        if (num1!= null) {
          Q.offer(num1);
        }
        nums1[i] = num2;
        i++;
        j++;
      } else if (numQ!=null && (num1==null || numQ<=num1) && (num2==null || numQ<=num2)) {
        if (num1 != null) {
          Q.offer(num1);
        }
        nums1[i] = numQ;
        Q.poll();
        i++;
      } else {
        throw new RuntimeException("Unexpected logic branch reached");
      }
    }
  }

}
