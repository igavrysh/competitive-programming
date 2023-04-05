package com.company;

public class SolutionMath {

    public int leastInterval(char[] tasks, int n) {
        int maxFQ = 0;
        int[] FQ = new int[26];
        int maxFQCount = 0;
        for (int i = 0; i < tasks.length; i++) {
            FQ[tasks[i]-'A']++;
            if (FQ[tasks[i]-'A'] == maxFQ) {
                maxFQCount++;
            } else if (FQ[tasks[i]-'A'] > maxFQ)  {
                maxFQ = FQ[tasks[i]-'A'];
                maxFQCount = 1;
            }
        }
        int spacesInBetweenTheMostFrequent = (n - (maxFQCount-1))*(maxFQ - 1);
        int idleCycles = Math.max(0, spacesInBetweenTheMostFrequent-(tasks.length-maxFQ*maxFQCount));
        return idleCycles + tasks.length;
    }
}
