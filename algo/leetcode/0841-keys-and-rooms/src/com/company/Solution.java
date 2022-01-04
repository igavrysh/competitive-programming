package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    int totalRooms = rooms.size();
    int visitedRooms = 0;
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }
    Queue<Integer> roomsToGo = new LinkedList<>();
    roomsToGo.offer(0);
    while (roomsToGo.size() != 0 && visitedRooms != totalRooms) {
      Integer room = roomsToGo.poll();

      if (room != null && visited[room] == false) {
        visitedRooms++;
        visited[room] = true;
        List<Integer> nextKeys = rooms.get(room);
        for (int key : nextKeys) {
          if (visited[key] == false) {
            roomsToGo.offer(key);
          }
        }
      }
    }
    return visitedRooms == totalRooms;
  }
}
