package leetcode.solutions;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int maxLengthReached = 0;
    Set<Character> elements = new HashSet<>();
    int start = 0;
    int end = 0;
    while (end < s.length() && start <= end) {
      Character element = s.charAt(end);
      if (elements.contains(element)) {
        Character elementToRemove = s.charAt(start);
        elements.remove(elementToRemove);
        start += 1;
      } else {
        elements.add(element);
        end += 1;
      }
      int delta = end - start;
      if (delta > maxLengthReached) {
        maxLengthReached = delta;
      }
    }
    return maxLengthReached;
  }
}
//--------------------------------------------------