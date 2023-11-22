class Solution {
    public String getWrongAnswers(int N, String C) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C.length(); i++) {
            if (C.charAt(i) == 'A') {
                sb.append('B');
            } else {
                sb.append('A');
            }
        }
        return sb.toString();
    }
}
