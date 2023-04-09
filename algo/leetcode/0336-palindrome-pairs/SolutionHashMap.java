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

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String s1 = w.substring(0, j);
                String s2 = w.substring(j, w.length());

                String s1reverse = reverse(s1);
                String s2reverse = reverse(s2);

                Integer s2RevIdx = map.get(s2reverse);
                if (isPalindrome(s1) && s2RevIdx != null && s2RevIdx != i) {
                    output.add(pair(s2RevIdx, i));
                }

                Integer s1RevIdx = map.get(s1reverse);
                if (isPalindrome(s2) && s1RevIdx != null && s1RevIdx != i) {
                    output.add(pair(i, s1RevIdx));
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
        char[] chrs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chrs.length; i++) {
            sb.append(chrs[chrs.length-1-i]);
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length/2; i++) {
            if (chrs[i] != chrs[chrs.length-1-i]) {
                return false;
            }
        }
        return true;
    }

}