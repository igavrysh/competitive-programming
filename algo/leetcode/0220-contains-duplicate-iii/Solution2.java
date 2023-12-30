import java.util.TreeSet;

public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    	TreeSet<Integer> tree = new TreeSet<Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (i - indexDiff - 1 >= 0) tree.remove(nums[i - indexDiff - 1 ]);
    		int upper = nums[i] + valueDiff;
    		int lower = nums[i] - valueDiff;
    		Integer floor = tree.floor(upper);
    		if (floor != null && floor >= lower) return true;
    		tree.add(nums[i]);
    	}
    	return false;
    }
}
