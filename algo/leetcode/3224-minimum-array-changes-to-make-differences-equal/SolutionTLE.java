import java.util.HashMap;

class SolutionTLE {
    public int minChanges(int[] nums, int k) {
        HashMap<Integer, Integer> M = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            int delta = Math.abs(nums[i] - nums[n-1-i]);
            M.put(delta, M.getOrDefault(delta, 0));
            for (int x = 0; x <= k; x++) {
                if (x==delta) {
                } else {
                    int n1_1 = x + nums[i];
                    int n1_2 = -x + nums[i];
                    int n2_1 = nums[n-1-i]-x;
                    int n2_2 = nums[n-1-i]+x;
                    if ((n1_1 >= 0 && n1_1 <= k) 
                        || (n1_2 >= 0 && n1_2 <= k) 
                        || (n2_1 >= 0 && n2_1 <= k) 
                        || (n2_2 >= 0 && n2_2<= k)
                    ) {
                        M.put(x, M.getOrDefault(x,0)+1);
                    } else {
                        M.put(x, M.getOrDefault(x,0)+2);
                    }
                }
            }
        }
        int min = n;
        for (int key : M.keySet()) {
            //System.out.println("k:" + key + ";v:" + M.get(key));
            min = Math.min(min, M.get(key));
        }
        return min; 
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[] nums = {0,1,2,3,3,6,5,4};
        int k = 6;
        int expOutput = 2;
        SolutionTLE sol = new SolutionTLE();
        int output = sol.minChanges(nums, k);
        boolean passed = output == expOutput;
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }
}