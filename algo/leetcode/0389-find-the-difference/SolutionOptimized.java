public class SolutionOptimized {
    public char findTheDifference(String s, String t) {
        int total = 0;
        for (char ch : s.toCharArray()) {
            total -= (ch-'a');
        }

        for (char ch : t.toCharArray()) {
            total += (ch -'a');
        }
        return (char)('a'+ total);
    }
}
