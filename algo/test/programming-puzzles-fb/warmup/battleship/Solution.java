class Solution {
    public double getHitProbability(int R, int C, int[][] G) {
        int ships = 0;
        if (G.length == 0) {
            return 0.0;
        }

        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[0].length; j++) {
                if (G[i][j] == 1) {
                    ships++;
                }
            }
        }
        return ships * 1.0 / (G.length * G[0].length);
    }
}
