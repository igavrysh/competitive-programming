package com.company;

import java.util.Arrays;

public class Solution {
  public String[] reorderLogFiles(String[] logs) {
    int insertIndex = logs.length-1;
    for (int i = logs.length-1; i >= 0; i--) {
      if (!isLetterLog(logs[i])) {
        String tmp = logs[insertIndex];
        logs[insertIndex] = logs[i];
        logs[i] = tmp;
        insertIndex--;
      }
    }
    if (insertIndex < 0) {
      return logs;
    }
    Arrays.sort(logs, 0, insertIndex+1, (String log1, String log2) -> {
      String body1 = getBody(log1);
      String body2 = getBody(log2);
      int result = body1.compareTo(body2);
      return result != 0 ? result : getIdentifier(log1).compareTo(getIdentifier(log2));
    });
    return logs;
  }

  private boolean isLetterLog(String log) {
    char firstChar = getBody(log).charAt(0);
    return firstChar - 'a' >= 0 && firstChar - 'a' < 26;
  }

  private String getBody(String log) {
    int spaceIndex = log.indexOf(' ');
    return spaceIndex == -1 ?  "" : log.substring(spaceIndex+1);
  }

  private String getIdentifier(String log) {
    int spaceIndex = log.indexOf(' ');
    return spaceIndex == -1 ?  "" : log.substring(0, spaceIndex);
  }

}
