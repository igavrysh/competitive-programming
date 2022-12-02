package com.company;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        int maxI = Math.min(s.length(), t.length());
        int i = 0;
        while (i < maxI && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        int matched = i;

        int unmatched = s.length() + t.length() - 2 * matched;

        if (k < unmatched) {
            return "No";
        }

        if (k >= s.length() + t.length()) {
            return "Yes";
        }

        if ((unmatched - k) % 2 == 0) {
            return "Yes";
        }

        return "No";
    }
}