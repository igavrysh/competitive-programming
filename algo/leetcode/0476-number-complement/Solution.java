class Solution {
    public int findComplement(int num) {
        int res = 0;
        int ptr = 0;
        while (num != 0) {
            res = res | (((num & 1) == 0 ? 1 : 0) << ptr);
            ptr++;
            num = num >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int input = 5;
        int expOutput = 2;
        Solution sol = new Solution();
        int output = sol.findComplement(input);
        boolean passed = output == expOutput;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }
}