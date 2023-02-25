import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> elements = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLengthReached = 0;
        while (end < s.length() && start <= end) {
            Character element = s.charAt(end);
            if (elements.containsKey(element)) {
                int delta = end - start;
                if (delta > maxLengthReached) {
                    maxLengthReached = delta;
                }

                Character elementToRemove = s.charAt(start);
                elements.remove(elementToRemove);
                start += 1;
            } else {
                elements.put(element, 1);
                end += 1;
            }
        }
        int delta = end - start;
        if (delta > maxLengthReached) {
            maxLengthReached = delta;
        }
        return maxLengthReached;
    }
}