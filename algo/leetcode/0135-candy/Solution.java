class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int minRating = ratings[0];
        int minI = 0;
        for (int i = 0; i < n; i++) {
            if (ratings[i] < minRating) {
                minRating = ratings[i];
                minI = i;
            }
        }

        int amount = 1;
        int prevCandy = 1;

        for (int i=minI+1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                amount += prevCandy+1;
                prevCandy = prevCandy+1;
            } else {
                amount += 1;
                prevCandy = 1;
            }
        }

        prevCandy = 1;
        for (int i=minI-1; i >=0 ; i--) {
            if (ratings[i] > ratings[i+1]) {
                amount += prevCandy+1;
                prevCandy = prevCandy+1;
            } else {
                amount += 1;
                prevCandy = 1;
            }
        }
        
        return amount;
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
        System.out.println("test1: " + (passed ? "passed" : "faile"));
    }

    public static void test2() {
        int[] ratings = {1,2,2};
        int expOutput = 4;
        Solution s = new Solution();
        int output = s.candy(ratings);
        boolean passed = output == expOutput;
        System.out.println("test2: " + (passed ? "passed" : "faile"));
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

