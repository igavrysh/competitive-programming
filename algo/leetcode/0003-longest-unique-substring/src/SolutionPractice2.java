import java.util.HashSet;

public class SolutionPractice2 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        if (s.length() == 0) {
            return 0;
        }
        int l=0,r=0;
        int N=s.length();
        int output = 0;
        while (r<N) {
            char rCh = s.charAt(r);
            if (!set.contains(rCh)) {
                output = Math.max(output, r-l+1);
                set.add(rCh);
                r++;
            } else {
                char lCh = s.charAt(l);
                set.remove(lCh);
                l++;
            }
        }
        return output;
    }
}
