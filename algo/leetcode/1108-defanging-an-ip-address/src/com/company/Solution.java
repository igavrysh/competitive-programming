package com.company;

public class Solution {
  public String defangIPaddr(String address) {
    String output = "";
    for (int i = 0; i < address.length(); i++) {
      if (address.charAt(i) == '.') {
        output += "[.]";
      } else {
        output += address.charAt(i);
      }
    }
    return output;
  }
}
