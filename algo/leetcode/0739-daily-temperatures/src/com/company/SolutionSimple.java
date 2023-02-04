package com.company;

class SolutionSimple {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i+1;
            int higherTempIndx = 0;
            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                j++;
            }
            if (j < temperatures.length && temperatures[j] > temperatures[i]) {
                higherTempIndx = j-i;
            }
            output[i] = higherTempIndx;
        }
        return output;
    }
}