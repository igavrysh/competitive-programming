class SolutionBs {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] nums = {10,9,2,5,3,7,101,18};
        SolutionBs s = new SolutionBs();
        int output = s.lengthOfLIS(nums);
        int expectedOutput = 4;
        boolean passed = output == expectedOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}

// n = 6
// 0,1,0,3,2,3
// length = 1
/*
tails = 
[0,0,0,0,0,0]
i = 0, size = 0

tails
[0,0,0,0,0,0]



 */