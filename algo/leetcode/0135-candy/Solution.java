import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] cand = new int[N];
        Arrays.fill(cand, 1);
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i-1]) {
                cand[i] = cand[i-1]+1;
            }
        }

        for (int i = N-1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                cand[i-1] = Math.max(cand[i-1], cand[i]+1);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res += cand[i];
        }

        return res;        
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int[] ratings = {1,0,2};
        int expOutput = 5;
        Solution s = new Solution();
        int output = s.candy(ratings);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

    public static void test2() {
        int[] ratings = {1,2,2};
        int expOutput = 4;
        Solution s = new Solution();
        int output = s.candy(ratings);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "failed"));
    }

    public static void test3() {
        int[] ratings = {1,3,2,2,1};
        int expOutput = 7;
        Solution s = new Solution();
        int output = s.candy(ratings);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "faile"));
    }
}

