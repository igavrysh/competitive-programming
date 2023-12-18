### 199. Binary Tree Right Side View

https://leetcode.com/problems/binary-tree-right-side-view/description/

`Medium`

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

**Example 1**:

![ex1](ex1.jpg)

```
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
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
