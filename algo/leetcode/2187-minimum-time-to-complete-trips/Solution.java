class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long bad = 0;
        long good = time[0] * (long)totalTrips;
        while (good-bad > 1) {
            long m = bad + (good - bad) / 2;
            boolean check = check(m, time, totalTrips);
            if (check) {
                good = m;
            } else {
                bad = m;
            }
        }
        return good;
    }
    private boolean check(long m, int[] time, int totalTrips) {
        long total = 0;
        for (int i = 0; i < time.length;i++) {
            total += m/time[i];
            if (total >= totalTrips) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        test123();
    }
    public static void test123() {
        int[] time = {690709,79,156068,359659};
        int totalTrips = 985484;
        long exp_output = 77787982;
        Solution sol = new Solution();
        long output = sol.minimumTime(time, totalTrips);
        boolean passed = exp_output == output;
        System.out.println("test123: " + (passed ? "passed" : "failed"));
    }
}