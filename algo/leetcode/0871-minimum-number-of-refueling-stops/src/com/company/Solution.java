package com.company;

import java.util.HashMap;

public class Solution {

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    if (stations.length == 0) {
      if (startFuel >= target) {
        return 0;
      } else {
        return -1;
      }
    }
    HashMap<String, Integer> acc = new HashMap<>();
    helper(-1, 0, startFuel, target, acc, stations);
    String key = key(-1, 0, startFuel);
    Integer value = acc.get(key);
    if (value == null) {
      return -1;
    }
    return value;
  }

  private String key(int currS, int stops, int fuel) {
    return String.valueOf(currS) + "_" + String.valueOf(stops) + "_" + String.valueOf(fuel);
  }

  private Integer helper(
      int currS,
      int stops,
      int fuel,
      int target,
      HashMap<String, Integer> acc,
      int[][] stations
  ) {
    String key = key(currS, stops, fuel);
    Integer value = acc.get(key);
    if (value != null) {
      return value;
    }

    if (fuel < 0) {
      return -1;
    }

    if (currS == stations.length) {
      return stops;
    }

    int currentStationFuel = currS == -1 ? 0 : stations[currS][1];
    int distanceToNextStation = 0;
    if (currS >= 0 && currS+1 < stations.length) {
      distanceToNextStation = stations[currS+1][0]-stations[currS][0];
    } else if (currS == -1 && currS+1 < stations.length) {
      distanceToNextStation = stations[currS+1][0];
    } else if (currS+1 == stations.length && currS < stations.length) {
      distanceToNextStation = target-stations[currS][0];
    }

    int refillsNoStops = helper(
        currS+1,
        stops+1,
        fuel+currentStationFuel-distanceToNextStation,
        target,
        acc,
        stations);

    int passesNoStops = helper(
        currS+1,
        stops,
        fuel-distanceToNextStation,
        target,
        acc,
        stations);

    int output = -1;

    if (refillsNoStops == -1 && passesNoStops != -1) {
      output = passesNoStops;
    } else if (refillsNoStops != -1 && passesNoStops == -1) {
      output = refillsNoStops;
    } else {
      output = Math.min(refillsNoStops, passesNoStops);
    }

    acc.put(key, output);
    return output;
  }

}
