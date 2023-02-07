package com.company;

import java.util.Stack;

/*

[2,1,5,6,2,3]

initial: [0]
i=0: [2;i=0, 0;i=-1]
i=1: curr h<2 
pop 2: 2

 */
public class  SolutionPractice2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer[]> S = new Stack<>();
        S.push(new Integer[]{0, -1});
        int output = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currH = i < heights.length ? heights[i] : 0;
            Integer[] pair = null;
            while (S.peek()[0] > currH) {
                pair = S.pop();
                int area = pair[0]*(i-1-pair[1]+1);
                if (area > output) {
                    output = area;
                }
            }
            if (pair != null) {
                S.push(new Integer[]{currH, pair[1]});
            } else {
                S.push(new Integer[]{currH, i});
            }
        }
        return output;
    } 
}
