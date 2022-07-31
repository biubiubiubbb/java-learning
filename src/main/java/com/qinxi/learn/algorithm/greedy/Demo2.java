package com.qinxi.learn.algorithm.greedy;

import org.junit.Test;

public class Demo2 {

    @Test
    public void test() {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }


}
