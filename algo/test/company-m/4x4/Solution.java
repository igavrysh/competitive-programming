import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public void transform(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        HashMap<Integer, Integer[]> M = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                M.put(matrix[i][j], new Integer[]{i,j});
            }
        }

        for (int num = 1; num <= R*C; num++) {
            putNumOnRightPlace(num, M, matrix); 
        } 
    }

    private void putNumOnRightPlace(int curr, HashMap<Integer, Integer[]> M, int[][] matrix) {
        System.out.println("\nsetting " + curr + " into right place: ");
        print(matrix);
        int R = matrix.length;
        int C = matrix[0].length;
        Integer[] coord = M.get(curr);
        if (coord == null) {
            throw new RuntimeException("unexp state");
        }

        int finalR = (curr - 1) / C;
        int finalC = (curr - 1) % C;
        if (finalR == coord[0] && finalC == coord[1]) {
            return;
        }

        if (finalR > coord[0] || (finalR == coord[0] && finalC > coord[1])) {
            throw new RuntimeException("unexp state"); 
        }

        System.out.println("by columns move");
        for (int delta = 1; delta <= Math.abs(finalC - coord[1]); delta++) {
            int mult = finalC > coord[1] ? 1 : -1;
            int nextI = coord[0];
            int nextJ = coord[1] + mult;
            int next = matrix[nextI][nextJ];
            swap(curr, next, M, matrix);
            coord[0] = nextI;
            coord[1] = nextJ;

            print(matrix);
        }

        System.out.println("by rows move");
        for (int delta = 1; delta <= Math.abs(finalR - coord[0]); delta++) {
            int nextI = coord[0] - 1;
            int nextJ = coord[1];
            int next = matrix[nextI][nextJ];
            swap(curr, next, M, matrix);
            coord[0] = nextI;
            coord[1] = nextJ;

            print(matrix);
        }
    }

    private void swap(int curr, int next, HashMap<Integer, Integer[]> M, int[][] matrix) {
        Integer[] coord = M.get(curr);
        Integer[] nextCoord = M.get(next);
        int nextI = nextCoord[0];
        int nextJ = nextCoord[1];
        matrix[nextI][nextJ] = curr;
        matrix[coord[0]][coord[1]] = next;
        Integer[] tmp = M.get(curr);
        M.put(curr, M.get(next));
        M.put(next, tmp);
    }

    private void print(int[][] matrix) {
        System.out.println("=========================");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[0].length-1) {
                    System.out.print(",\t");
                } else {
                    System.out.println("");
                }
            }
        }
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int[][] matrix = {
            {   1,  14, 7,  11  },
            {   16, 6,  13, 8   },
            {   9,  10, 4,  12  },
            {   3,  2,  15, 5   }
        };
        int[][] expMatrix = {
            {   1,  14, 7,  11  },
            {   16, 6,  13, 8   },
            {   9,  10, 4,  12  },
            {   3,  2,  15, 5   }
        };
        Solution sol = new Solution();
        sol.transform(matrix);
        boolean passed = true;
        for (int i = 0; i < matrix.length; i++) {
            passed = passed && Arrays.equals(matrix[i], expMatrix[i]);
        }
        System.out.println("test1: " + (passed ? "passed" : "failed"));
    }

}