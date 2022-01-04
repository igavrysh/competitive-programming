package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    int i = 0;
    int currStringLength = 0;
    int lSize = 0;
    List<Integer> line = new ArrayList<>();
    List<String> output = new ArrayList<>();
    while (i < words.length) {
      if (line.size() == 0) {
        line.add(i);
        lSize += words[i].length();
        currStringLength += words[i].length();
      } else if (currStringLength + 1 + words[i].length() <= maxWidth) {
        line.add(i);
        lSize += words[i].length();
        currStringLength += (words[i].length() + 1);
      } else {
        int spacesI = (int)((maxWidth - lSize) * 1.0 / ((line.size() - 1) * 1.0));
        int bigSpaceQ = maxWidth - lSize - spacesI * (line.size()-1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < line.size(); j++) {
          if (j > 0) {
            sb.append(String.join("",
                Collections.nCopies(spacesI + (j <= bigSpaceQ ? 1 : 0), " ")));
          }
          sb.append(words[line.get(j)]);
        }
        while(sb.length() < maxWidth) {
          sb.append(" ");
        }
        output.add(sb.toString());
        line = new ArrayList<>();
        line.add(i);
        lSize = words[i].length();
        currStringLength = words[i].length();
      }
      i++;
    }
    StringBuilder sb = new StringBuilder();
    int size = 0;
    for (int j = 0; j < line.size(); j++) {
      if (j > 0) {
        sb.append(" ");
        size++;
      }
      sb.append(words[line.get(j)]);
      size += words[line.get(j)].length();
    }
    while (size < maxWidth) {
      sb.append(" ");
      size++;
    }
    output.add(sb.toString());
    return output;
  }
}
