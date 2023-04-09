import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionHashMap {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> output = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <  words.length; i++) {
            map.put(words[i], i);
        }

        if (map.containsKey("")) {
            int idxEmptyStr = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != idxEmptyStr && isPalindrome(words[i])) {
                    output.add(pair(i, idxEmptyStr));
                    output.add(pair(idxEmptyStr, i));
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String reverse = reverse(words[i]);
            Integer reverseI = map.get(reverse);
            if (reverseI != null && i != reverseI 
                && isPalindrome(words[i]+reverse)) {
                output.add(pair(i, reverseI));
            }
        }

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 1; j < w.length(); j++) {
                String s1 = w.substring(0, j);
                String s2 = w.substring(j, w.length());
                if (isPalindrome(s1)) {
                    String s2Rev = reverse(s2);
                    Integer s2RevI = map.get(s2Rev);

                    if (s2RevI != null && i != s2RevI) {
                        output.add(pair(s2RevI, i));
                    }
                }
                
                if (isPalindrome(s2)) {
                    String s1Rev = reverse(s1);
                    Integer s1RevI = map.get(s1Rev);

                    if (s1RevI != null && i != s1RevI) {
                        output.add(pair(i, s1RevI));
                    }
                }
            }
        }

        return output;
    }

    private List<Integer> pair(int i1, int i2) {
        List<Integer> output = new ArrayList<>();
        output.add(i1);
        output.add(i2);
        return output;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n-1-i)) {
                return false;
            }
        }
        return true;
    }
}