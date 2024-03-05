# Left Right Side of Binary Tree

Something similar to  https://leetcode.com/problems/binary-tree-right-side-view/, task description below

But difference - instead of just printing right side view, print `left side - right side view` of binary tree in order, `left side bottom - .... - left side top = root = right side top -. ... right side bottom`

Return this order node values in output array

**Example**
```
Input:
       8
      / \ 
    4    10
  / \    / \
 2   5  9   14
/    \
1    7

Output: [1,2,4,8,10,14,7]
```



## 199. Binary Tree Right Side View

https://leetcode.com/problems/binary-tree-right-side-view/

`Medium`

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

**Example 1**:

![ex1](left-right-side-of-binary-tree.jpg)

```
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
```

**Example 2**:
```
Input: root = [1,null,3]
Output: [1,3]
```

**Example 3**:
```
Input: root = []
Output: []
``` 

**Constraints**:

* The number of nodes in the tree is in the range `[0, 100]`.
* `-100 <= Node.val <= 100`

