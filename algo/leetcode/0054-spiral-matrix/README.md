# 54. Spiral Matrix 
    
Medium

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

![ex1](ex1.jpg)
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

Example 2:

![ex2](ex2.jpg)
```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

Constraints:

* m == matrix.length
  
* n == matrix[i].length 
  
* 1 <= m, n <= 10 
  
* -100 <= matrix[i][j] <= 100



w, h-1, w-1, h-2, w-2, h-3, w-3

