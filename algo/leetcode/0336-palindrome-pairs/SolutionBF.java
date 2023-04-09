import java.util.ArrayList;
import java.util.List;

public class SolutionBF {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isPalindrome(words[i]+words[j])) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    output.add(t);
                } 
                if (isPalindrome(words[j]+words[i])) {
                    List<Integer> t = new ArrayList<>();
                    t.add(j);
                    t.add(i);
                    output.add(t);
                }
            }
        }
        return output;
    }

    private boolean isPalindrome(String str) {
        char[] chrs = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            if (chrs[i] != chrs[chrs.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}
