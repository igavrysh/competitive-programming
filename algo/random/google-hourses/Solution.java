class Solution {

    public int minHourses(int n) {
        int[] DP = new int[n+1];
        DP[0] = 0; DP[1] = 0; DP[2] = 0;
        DP[3] = 0; DP[4] = 1; DP[5] = 1;

        for (int i = 6; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i/2; j++) {
                if (Math.min(i-j, 3) + Math.min(j, 3) < i) {
                    int l = DP[i-j];
                    int r = DP[j];
                    int rem = DP[Math.min(i-j, 3) + Math.min(j, 3)];
                    min = Math.min(min, l+r+rem);
                }
            }
            DP[i] = min;
        }
        return DP[n];
    }

    public static void main(String[] args) {
        int n = 25;
        Solution s = new Solution();
        int min = s.minHourses(25);
        System.out.println("for hourses n=" + n + " min races = "+min);
    }
}