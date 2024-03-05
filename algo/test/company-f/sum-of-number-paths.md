```
the candidate is given a binary tree, with integer values at each node. The candidate is expected to return the sum of the numbers represented by the values on each node in each root-to-leaf path. The level of the tree is the significance digit on the number. Please see the example below.

root=> 2
      / \
     3   4
   /  \
  1    5
The output should be: 231 + 235 + 24 = 490
```

```
import java.io.*;
import java.util.*;

public class Solution {
  public static class TreeNode {
    public TreeNode l;
    public TreeNode r;
    public int val;
  }

  // root = null 
  public int sumOfPathNumbers(TreeNode root) {
    // TODO: check root == null
    int[] output = {0};
    DFS(0, root, output);
    return output[0];
  }

  private void DFS(int acc, TreeNode node, int[] output) {
    if (node == null) { return; }

    acc = acc*10 + node.val;

    if (node.left == null && node.right == null) {
      output[0] += acc;
    }

    if (node.left != null) {
      DFS(acc, node.left, output);
    }

    if (node.right != null) {
      DFS(acc, node.righ, output);
    }
  }
}