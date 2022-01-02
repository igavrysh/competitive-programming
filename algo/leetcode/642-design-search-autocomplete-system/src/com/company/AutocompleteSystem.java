package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.util.Pair;

public class AutocompleteSystem {
  class Node {
    Node[] items = new Node[27];
    boolean isEOS = false;
    int w = 0;
    char c;
  }

  private Node root = new Node();

  private Node currNode = root;
  private String currSentence = null;

  public AutocompleteSystem(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      add(sentences[i], times[i]);
    }
  }

  public List<String> input(char c) {
    List<String> output = new ArrayList<>();

    if (c != '#' && currNode != null && currNode.items[idx(c)] != null) {
      if (currSentence == null) {
        currSentence = "";
      }
      currSentence += c;
      currNode = currNode.items[idx(c)];
      output = top(3);
    } else {
      if (c == '#') {
        currSentence += c;
        output = top(3);
        add(currSentence);



      } else {
        currSentence += c;
        currNode = null;
      }

      if (currSentence != "" ) {
        if (currNode != null) {
          add(currSentence, currNode.w + 1);
        } else {
          add(currSentence, 1);
        }
      }

      // add to trie, if not exists with w 1, mark currNode as isEOS = true
      // increment weight by 1 if exists

      if (currSentence != null) {
        output.add(currSentence);
      }
      currNode = root;
      currSentence = null;
      return output;



    }

    List<String> output = new ArrayList<>();
    currNode = root;
    currSentence = "";
    return output;
  }

  private void add(String sentence, int w) {
    if (sentence.length() == 0) {
      return;
    }
    sentence += "#";

    Node n = root;
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);
      if (c == '#') {
        n.isEOS = true;
        break;
      }

      int idx = idx(c);
      Node next = n.items[idx];
      if (next != null) {
        next.w = Math.max(next.w, w);
      } else {
        next = new Node();
        next.c = c;
        next.w = w;
      }

      n.items[idx] = next;
      n = next;
    }
  }

  private int idx(char c) {
    return c == ' ' ? 26 : c - 'a';
  }

  private List<String> top(int topN) {
    PriorityQueue<Pair<Node, String>> outputQ = new PriorityQueue<Pair<Node, String>>((p1, p2) -> {
      return p1.getKey().w == p2.getKey().w
          ? p1.getValue().compareTo(p2.getValue())
          : p2.getKey().w - p1.getKey().w;
    });

    if (currNode == null) {
      return new ArrayList<>();
    }
    Queue<Node> nds = new LinkedList<>();
    Queue<String> sents = new LinkedList<>();
    nds.add(currNode);
    sents.add(currSentence);
    while(!nds.isEmpty()) {
      Node nd = nds.poll();
      String sent = sents.poll();

      if (nd.isEOS) {
        outputQ.add(new Pair<>(nd, sent));
      }

      PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
        return n1.w == n2.w ? Character.compare(n2.c, n1.c) : n2.w - n1.w;
      });

      for (int i = 0; i < nd.items.length; i++) {
        if (nd.items[i] != null) {
          pq.add(nd.items[i]);
        }
      }

      int counter = 0;
      while (counter < 3 && pq.size() > 0) {
        Node nxt = pq.poll();
        nds.add(nxt);
        sents.add(sent + nxt.c);
      }
    }

    List<String> output = new ArrayList<>();
    while (output.size() < topN && outputQ.size() > 0) {
      Pair<Node, String> p = outputQ.poll();
      if (!p.getValue().isEmpty()) {
        output.add(p.getValue());
      }
    }
    return output;
  }

}
