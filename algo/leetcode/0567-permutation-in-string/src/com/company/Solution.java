import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1M = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int letter = s1.charAt(i)-'a';
            s1M[letter]++;
        }
        int l=0;
        int[] s2M = new int[26];
        for (int r=0;r<s2.length();r++) {
            s2M[s2.charAt(r)-'a']++;
            if (r-l+1>s1.length()) {
                s2M[s2.charAt(l)-'a']--; 
                l++;
            }
            if (Arrays.equals(s1M, s2M)) {
                return true;
            }
        }
        return false;
    }
}