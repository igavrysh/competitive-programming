package com.company;

/*
 * https://github.com/igavrysh/competitive-programming/tree/master/algo/leetcode
 */ 
import java.util.Random;

public class SolutionRandom {
    public int majorityElement(int[] nums) {
        int N = nums.length;
        Random rand = new Random();
        while (true) {
            int num = nums[rand.nextInt(N)];
            int fq = 0;
            for (int i = 0; i < N; i++) {
                if (nums[i] == num) {
                    fq++;
                }
                if (fq > N/2) {
                    return num;
                }
            }
        }
    }
}
