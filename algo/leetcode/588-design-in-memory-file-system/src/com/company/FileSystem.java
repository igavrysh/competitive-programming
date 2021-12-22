package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FileSystem {

  Node root;

  public FileSystem() {
    root = new Node();
  }

  public List<String> ls(String path) {
    Node node = traverse(path);
    List<String> output = new ArrayList<>();

    if (node.isDir) {
      for (String name : node.items.keySet()) {
        output.add(name);
      }
      output.sort((String name1, String name2) -> name1.compareTo(name2));
    } else {
      output.add(node.name);
    }

    return output;
  }

  private Node traverse(String path) {
    String[] pathNames = path.split("/");
    Node node = root;
    for (int i = 0; i < pathNames.length; i++) {
      String name = pathNames[i];
      if (i == 0 && name.isEmpty()) {
        continue;
      }
      Node next = node.items.getOrDefault(name, new Node());
      next.name = name;
      node.items.put(name, next);
      node = next;
    }
    return node;
  }

  public void mkdir(String path) {
    Node node = traverse(path);
    node.isDir = true;
  }

  public void addContentToFile(String filePath, String content) {
    Node node = traverse(filePath);
    node.isDir = false;
    node.content += content;
  }

  public String readContentFromFile(String filePath) {
    Node node = traverse(filePath);
    return node.content;
  }

  class Node {
    HashMap<String, Node> items = new HashMap<>();
    boolean isDir = true;
    String content = "";
    String name = "";
  }
}