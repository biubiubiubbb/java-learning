package com.qinxi.learn.algorithm.greedy;

import org.junit.Test;

public class Demo {

    @Test
    public void  test() {
        System.out.println(canJump(new int[]{1,1,1,1}));
    }

    public boolean canJump(int[] nums) {
        if(nums.length <= 1) {
            return true;
        }
        for(int i = 0; i < nums.length; i++) {
            int cur = i;
            if(i + nums[i] >= nums.length - 1) {
                //可以达到最后一个
                return true;
            }
            while(i < nums.length) {
                //找到0所在的位置
                if(nums[i] !=  0) {
                    i++;
                } else {
                    break;
                }
            }
            if(cur == i) {
                //没变过
                return false;
            }
            if(i >= nums.length - 1) {
                //最后一个
                return true;
            }
            while(cur < i) {
                if(cur + nums[cur] > i) {
                    break;
                }
                cur++;
            }
            if(cur == i) {
                return false;
            }
        }
        return true;
    }

}
