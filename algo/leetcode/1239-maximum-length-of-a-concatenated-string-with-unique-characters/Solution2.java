import java.util.List;

public class Solution2 {
    public int maxLength(List<String> arr) {
        int[] maxLength = {0};
        int[] nums = new int[arr.size()];
        int i = 0;
        for (String s : arr) {
            int currVal = 0;
            char[] chrs = s.toCharArray();
            for (char ch : chrs) {
                int val = (1 << (ch-'a'));
                if ((val & currVal) != 0) {
                    currVal = 0;
                    break;
                }
                currVal = currVal | (1 << (ch-'a'));
            }
            nums[i++] = currVal;
        }

        BT(0, 0, 0, maxLength, nums, arr);

        return maxLength[0];
    }

    private void BT(int s, int acc, int currLength, int[] maxLength, int[] nums, List<String> arr) {
        if (s>=arr.size()) return;

        int sLength = arr.get(s).length();

        BT(s+1, acc, currLength, maxLength, nums, arr);

        int currVal = nums[s];
        if (currVal != 0 && (acc & currVal) == 0) {
            maxLength[0] = Math.max(maxLength[0], currLength+sLength);
            BT(s+1, acc | currVal, currLength+sLength, maxLength, nums, arr);
        }
    }
}
