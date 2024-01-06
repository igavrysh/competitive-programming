import java.util.ArrayList;
import java.util.List;

public class SolutionBF {

    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return MC(list);
    }

    private int MC(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int maxScore = 0;
        for (int i = 0; i < nums.size(); i++) {
            int currScore = (i > 0 ? nums.get(i - 1) : 1)
                    * nums.get(i)
                    * (i < nums.size() - 1 ? nums.get(i + 1) : 1);
            Integer val = nums.remove(i);
            int output = MC(nums);
            nums.add(i, val);
            if (currScore + output > maxScore) {
                maxScore = currScore + output;
            }
        }
        return maxScore;
    }

    private static void test1() {
        SolutionBF s = new SolutionBF();
        int output = s.maxCoins(new int[] { 3, 1, 5, 8 });
        boolean passed = output == 167;
        System.out.println("test1:" + (passed ? "passed" : "failed"));
    }

    public static void main(String[] args) {
        test1();
    }
}
