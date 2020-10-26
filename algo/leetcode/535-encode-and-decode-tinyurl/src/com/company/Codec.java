package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Codec {

  private List<String> DB;

  private String mapping =
      "0123456789"
      + "abcdefghijklmnopqrstuvwxyz"
      + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private Map<Character, Integer> charToIntDict;

  public Codec() {
    DB = new ArrayList<>();
    charToIntDict = new HashMap<>();
    for (int i = 0; i < mapping.length(); i++) {
      charToIntDict.put(mapping.charAt(i), i);
    }
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    DB.add(longUrl);
    int index = DB.size() - 1;
    return "http://tinyurl.com/" + intToTinyUrl(index);
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    if (shortUrl.startsWith("http://tinyurl.com/")) {
      shortUrl = shortUrl.replace("http://tinyurl.com/", "");
    }
    int index = tinyUrlToInt(shortUrl);
    return DB.get(index);
  }

  private String intToTinyUrl(int n) {
    int base = mapping.length();
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      int curr = n % base;
      sb.append(mapping.charAt(curr));
      n /= base;
    }

    while (sb.length() <= 6) {
      sb.append(mapping.charAt(0));
    }
    return sb.toString();
  }

  private int tinyUrlToInt(String tinyUrl) {
    int result = 0;
    for (int i = 0; i < tinyUrl.length(); i++) {
      result = result * mapping.length() + charToIntDict.get(tinyUrl.charAt(i));
    }
    return result;
  }
}
