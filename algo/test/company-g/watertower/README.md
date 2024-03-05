# Build a Watertower

Find the coordinates where `watertower` should be built to supply two neighboring villages with water

`Watertower` should be built on highest mountain and both villages should receive a free floating water from it. 

Restriction: water can flow from the cell with higher altitude to the neighboring cell with lower or equal altitude. 

Cell Neighbors: top, bottom, left, right

```
heightMap = [
    [   7,  1,  2,  4,  5   ],
    [   6,  4,  6,  3,  2   ],
    [   5,  2,  2i, 1,  9   ],
    [   6,  6,  4,  2,  3   ],
    [   2,  1i, 3,  4,  6   ]
]
```

Villages: (2,2), (4,1) - VIllages are marked as i for simplicity.

Input: heightMap, coordinates of two villages

Output: coordinates of water tower

0 <= R,C <= 10K

API:

* `int[] waterTower(int[][] heightMap, int[] village1, int[] villabe2)`, based on height map - matrix RxC and coordinates of `village1` = `[r1,c1]`, and `village2` = `[r2,c2]` return the coordinates of watertower `watertower` = `[r_watertower, c_watertower]`