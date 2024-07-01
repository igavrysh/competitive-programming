# Intuition ✨
Harness the power of prefix sums for matrices and insightful hints to tackle the Brute Force solution!


# Approach 🚀

* To count the number of 1s in any row or column, regardless of the start or end indices for rows/columns, use a prefix submatrix representing the number of 1s in the submatrix `(0..i)x(0..j)`.

___
* Split cases vertically and horizontally:
  * vertically:
    ```
    X
    -
    Y
    ```

  * horizontally
    ```
    X | Y
    ```
`X` & `Y` themselves can also split into 2 or 1 squares based on the number of squares already used for splitting in the case.

* vertially:
  * top square `X` splits:
    * vertially:
    ```
    X1
    -
    X2
    -
    Y
    ```
    * horizontally:
    ```
    X1 | X2
    -------
       Y
    ```
  * bottom square `Y` splits:
    * vertially:
    ```
    X
    -
    Y1
    -
    Y2
    ```
    * horizontally:
    ```
       X
    -------
    Y1 | Y2
    ```
   

* horizontally:
  * right square `X` splits:
    * vertically
    ```
    X1 |
    -  | Y
    X2 |
    ```
    * horizontally
    ```
    X1 | X2 | Y
    ```
  * left square `Y` splits:
    * vertically
    ```
      | Y1
    X | -
      | Y2
    ```
    * horizontally
    ```
    X  | Y1 | Y 2
    ```




# Complexity 🌟

- Time complexity:$$O(rows \times cols  \times rows  \times cols  \times max(rows,cols)) \approx 30^5 \approx 2.5  \times 10^7$$ 

- Space complexity: $$O(rows  \times cols \times rows \times cols) \approx 30^4= 810,000$$


# Code 💻✨
The `Solution` class implements a method to find the minimum sum of areas needed to cover all `1s` in a `grid`. It uses prefix sums to quickly calculate subarray sums and tries different ways to split the grid vertically and horizontally to minimize the total area. 

The helper methods, `minAreaToCoverOnesWith2Rec` and `minAreaToCoverOnes`, are used to calculate the minimum area required to cover ones with two rectangles and one rectangle respectively. 

The code handles caching (commented out since it does not improve runtime) for optimization and carefully updates the prefix sum array to facilitate quick calculations. 🌟

```
class Solution {
    private int[][] pSq = {{}};
    //private Integer[][][][] cache2x = {{{{}}}};
    //private Integer[][][][] cache1x = {{{{}}}};

    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        //cache2x = new Integer[rows][rows][cols][cols];
        //cache1x = new Integer[rows][rows][cols][cols];
        pSq = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pSq[i][j] = grid[i][j] 
                    + (i-1 >= 0 ? pSq[i-1][j] : 0)
                    + (j-1 >= 0 ? pSq[i][j-1] : 0)
                    - (i-1 >= 0 && j-1 >=0 ? pSq[i-1][j-1] : 0); 
            }
        }
        int minArea = rows*cols;
        int x = 0, y = 0;

        // split vertically 
        // x
        // -
        // y
        for (int i = 0; i < rows-1; i++) {
            x = minAreaToCoverOnesWith2Rec(0, i, 0, cols-1);
            if (x != -1) {
                y = minAreaToCoverOnes(i+1, rows-1, 0, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
            
            x = minAreaToCoverOnes(0, i, 0, cols-1);
            if (x != -1) {
                y = minAreaToCoverOnesWith2Rec(i+1, rows-1, 0, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        // split horizontally
        // x | y
        for (int j = 0; j < cols-1; j++) {
            x = minAreaToCoverOnesWith2Rec(0, rows-1, 0, j);
            if (x != -1) {
                y = minAreaToCoverOnes(0, rows-1, j, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
            
            x = minAreaToCoverOnes(0, rows-1, 0, j);
            if (x != -1) {
                y = minAreaToCoverOnesWith2Rec(0, rows-1, j+1, cols-1);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        return minArea;
    }

    private int minAreaToCoverOnesWith2Rec(int sI, int eI, int sJ, int eJ) {
        //if (cache2x[sI][eI][sJ][eJ] != null) {
        //    return cache2x[sI][eI][sJ][eJ];
        //}
        int rows = pSq.length;
        int cols = pSq[0].length;
        int minArea = rows*cols+1;
        // split vertically
        // x
        // -
        // y
        for (int i = sI; i <= eI-1; i++) {
            int x = minAreaToCoverOnes(sI, i, sJ, eJ);
            if (x != -1) {
                int y = minAreaToCoverOnes(i+1, eI, sJ, eJ);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        // split horizontally
        // x | y
        for (int j = sJ; j <= eJ-1; j++) {
            int x = minAreaToCoverOnes(sI, eI, sJ, j);
            if (x != -1) {
                int y = minAreaToCoverOnes(sI, eI, j+1, eJ);
                if (y != -1) {
                    minArea = Math.min(minArea, x+y);
                }
            }
        }
        int res = minArea == rows*cols+1 ? -1 : minArea;
        //cache2x[sI][eI][sJ][eJ] = res;
        return res;
    }

    private int minAreaToCoverOnes(int sI, int eI, int sJ, int eJ) {
        //if (cache1x[sI][eI][sJ][eJ] != null) {
        //    return cache1x[sI][eI][sJ][eJ];
        //}
        int i = sI;
        int j = sJ;
        int topI = -1; 
        int topJ = -1;
        while (i <= eI && j <= eJ) {
            int onesInRowI = pSq[i][eJ] 
                - (i-1>=0 ? pSq[i-1][eJ] : 0)
                - (sJ-1>=0 ? pSq[i][sJ-1] : 0)
                + (i-1>=0 && sJ-1 >= 0 ? pSq[i-1][sJ-1] : 0);
            int onesInColJ = pSq[eI][j]
                - (sI-1>=0 ? pSq[sI-1][j] : 0)
                - (j-1>=0 ? pSq[eI][j-1] : 0)
                + (sI-1>=0 && j-1>=0 ? pSq[sI-1][j-1] : 0);
            if (onesInRowI == 0 && onesInColJ == 0
            ) {
                i++;
                j++;
            } else if (onesInRowI == 0) {
                i++;
            } else if (onesInColJ == 0) {
                j++;
            } else {
                topI = i;
                topJ = j;
                break;
            }
        }
        if (topI == -1 || topJ == -1) {
            return -1;
        }

        int bottomI = -1;
        int bottomJ = -1;
        i = eI;
        j = eJ;

        while (i >= sI && j >= sJ) {
            int onesInRowI = pSq[i][eJ] 
                - (i-1>=0 ? pSq[i-1][eJ] : 0)
                - (sJ-1>=0 ? pSq[i][sJ-1] : 0)
                + (i-1>=0 && sJ-1 >= 0 ? pSq[i-1][sJ-1] : 0);
            int onesInColJ = pSq[eI][j]
                - (sI-1>=0 ? pSq[sI-1][j] : 0)
                - (j-1>=0 ? pSq[eI][j-1] : 0)
                + (sI-1>=0 && j-1>=0 ? pSq[sI-1][j-1] : 0);
            if (onesInRowI == 0 && onesInColJ== 0
            ) {
                i--;
                j--;
            } else if (onesInRowI == 0) {
                i--;
            } else if (onesInColJ == 0) {
                j--;
            } else {
                bottomI = i;
                bottomJ = j;
                break;
            }
        }
        int res = (bottomI == -1 || bottomJ == -1 ? -1 : (bottomI-topI+1)*(bottomJ-topJ+1));
        //cache1x[sI][eI][sJ][eJ] = res;
        return res;
    }
}
```