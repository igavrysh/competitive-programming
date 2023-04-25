class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int[] ind = new int[3];
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (totalCount == 3) {
                break;
            }
            if (triplets[i][0] > target[0] 
                || triplets[i][1] > target[1] 
                || triplets[i][2] > target[2]) {
                continue;
            }

            if (triplets[i][0] == target[0] && ind[0]==0) {
                ind[0] = 1;
                totalCount++;
            }
            if (triplets[i][1] == target[1] && ind[1]==0) {
                ind[1] = 1;
                totalCount++;
            }
            if (triplets[i][2] == target[2] && ind[2]==0) {
                ind[2] = 1;
                totalCount++;
            }
        }
        return totalCount == 3;
    }
}