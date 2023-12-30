import java.util.HashMap;
import java.util.Map;

public class SolutionBuckets {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Long, Long> buckets = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            long val = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = val / ((long) valueDiff + 1);
            if(buckets.containsKey(bucket)
                || (buckets.containsKey(bucket - 1) && val - buckets.get(bucket - 1) <= valueDiff)
                || (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - val <= valueDiff)){
                    return true;
                }
            if(i >= indexDiff){
                long rVal = ((long) nums[i - indexDiff] - Integer.MIN_VALUE) / ((long)valueDiff + 1);
                buckets.remove(rVal);
            }
            buckets.put(bucket, val);
        }
        return false;
    }
}
