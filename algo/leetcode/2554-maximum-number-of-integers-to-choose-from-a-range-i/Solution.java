class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] ban_a = new boolean[(int)1e4+1];
        for (int i = 0; i < banned.length; i++) {
            ban_a[banned[i]] = true;
        }
        int sum = 0;
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (ban_a[i]) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test1() {
        int[] banned = {11};
        int n = 7;
        int maxSum = 50;
        int expOutput = 7;
        Solution sol = new Solution();
        int output = sol.maxCount(banned, n, maxSum);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] banned = {
            87,193,85,55,14,69,26,133,171,180,4,8,29,121,182,78,157,53,26,7,117,138,57,167,8,103,32,110,
            15,190,139,16,49,138,68,69,92,89,140,149,107,104,2,135,193,87,21,194,192,9,161,188,73,84,83,
            31,86,33,138,63,127,73,114,32,66,64,19,175,108,80,176,52,124,94,33,55,130,147,39,76,22,112,
            113,136,100,134,155,40,170,144,37,43,151,137,82,127,73
        };
        int n = 1079;
        int maxSum = 87;
        int expOutput = 9;
        Solution sol = new Solution();
        int output = sol.maxCount(banned, n, maxSum);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }
}