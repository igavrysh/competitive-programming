package java;
class Solution {

    public long getMinimumSecondsRequired(int N, int[] R, int A, int B) {
        long preCost = 0;
        for (int i = 0; i < N; i++) {
            if (R[i] < i+1) {
                preCost += (i+1 - R[i]) * A;
                R[i] = i+1;
            }
        }

        long cost = 0;
        for (int i = 1; i < N; i++){
            if (R[i] < i+1) {
                cost += (i+1 - R[i]) * A;
                R[i] = i+1;
            }

            for (int j = i; j <= 0; j--) {
                for (int k = j+1; k <=i ; k++) {
                    if (R[k] > R[k-1]+1) {
                        
                    }
                }
            }
        }

        return cost;
    }

}
