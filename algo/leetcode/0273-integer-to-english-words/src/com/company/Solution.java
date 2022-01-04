package com.company;

import java.util.HashMap;

public class Solution {

  private HashMap<Integer, String> dict;

  private String[] bigNum;

  public Solution() {
    dict = new HashMap<>();
    dict.put(1, "One");
    dict.put(2, "Two");
    dict.put(3, "Three");
    dict.put(4, "Four");
    dict.put(5, "Five");
    dict.put(6, "Six");
    dict.put(7, "Seven");
    dict.put(8, "Eight");
    dict.put(9, "Nine");
    dict.put(10, "Ten");
    dict.put(11, "Eleven");
    dict.put(12, "Twelve");
    dict.put(13, "Thirteen");
    dict.put(14, "Fourteen");
    dict.put(15, "Fifteen");
    dict.put(16, "Sixteen");
    dict.put(17, "Seventeen");
    dict.put(18, "Eighteen");
    dict.put(19, "Nineteen");
    dict.put(20, "Twenty");
    dict.put(30, "Thirty");
    dict.put(40, "Forty");
    dict.put(50, "Fifty");
    dict.put(60, "Sixty");
    dict.put(70, "Seventy");
    dict.put(80, "Eighty");
    dict.put(90, "Ninety");
    bigNum = new String[]{"Thousand", "Million", "Billion"};
  }

  private String smallToWord(int num) {
    String result = "";
    if (num / 100 != 0) {
      result += dict.get(num / 100) + " Hundred";
    }
    num = num % 100;
    if (num >= 1 && num <= 20) {
      if (result != "") {
        result += " ";
      }
      result += dict.get(num);
    } else {
      int dozens = num / 10;
      if (dozens != 0) {
        if (result != "") {
          result += " ";
        }
        result += dict.get(dozens * 10);
      }
      int rem = num % 10;
      if (rem != 0) {
        if (result != "") {
          result += " ";
        }
        result += dict.get(rem);
      }
    }
    return result;
  }

  public String numberToWords(int num) {
    String result = "";
    int remainder = num;
    int currentPortion = 0;
    int idx = -1;
    while (remainder > 0) {
      currentPortion = remainder % 1000;
      remainder = remainder / 1000;
      String portionResult = smallToWord(currentPortion);
      if (idx != -1 && !portionResult.isEmpty()) {
        portionResult = portionResult + " " + bigNum[idx];
      }
      if (result.isEmpty()) {
        result = portionResult;
      } else {
        if (!portionResult.isEmpty()) {
          result = portionResult + " " + result;
        }
      }
      idx++;
    }
    if (result.isEmpty()) {
      return "Zero";
    }
    return result;
  }
}
