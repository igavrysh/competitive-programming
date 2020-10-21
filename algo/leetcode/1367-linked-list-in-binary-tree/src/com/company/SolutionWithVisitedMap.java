package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionWithVisitedMap {

  private ListNode globalHead;
  private TreeNode globalTreeNode;

  private Map<ListNode, Map<TreeNode, Boolean>> visited;

  private int calls = 0;

  public boolean isSubPath(ListNode head, TreeNode root) {
    calls++;
    this.globalHead = head;
    this.globalTreeNode = root;
    this.visited = new HashMap<>();
    return DFS(head, root);
  }

  private boolean DFS(ListNode currentHead, TreeNode treeNode) {
    calls++;
    //if (calls) {
     // System.out.println("calls: " + calls);
    //}
    //System.out.println("path:" + path);

    if (currentHead == null) {
      return true;
    }

    if (treeNode == null) {
      return false;
    }

    if (visited.get(currentHead) != null
      && visited.get(currentHead).get(treeNode) != null
    ) {
      return visited.get(currentHead).get(treeNode);
    }

    boolean result = false;

    if (currentHead.val == treeNode.val) {
      if (DFS(currentHead.next, treeNode.left) == true) {
        result |= true;
      }
      if (DFS(currentHead.next, treeNode.right) == true) {
        result |= true;
      }
    }

    if (result == false) {

      if (DFS(globalHead, treeNode.left) == true) {
        result |= true;
      }

      if (DFS(globalHead, treeNode.right) == true) {
        result |= true;
      }
    }

    Map<TreeNode, Boolean> curr = visited.get(currentHead);
    if (curr != null) {
      curr.put(treeNode, result);
    } else {
      Map hm = new HashMap<>();
      hm.put(treeNode, result);
      visited.put(currentHead, hm);
    }

    return result;
  }

}
