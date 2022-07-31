package com.qinxi.learn.algorithm.backTracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo3 {


    private List<List<Integer>> result = new LinkedList<>();
    private boolean[] used;

    @Test
    public void test() {
        System.out.println("B".compareTo("A"));
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums, new LinkedList<Integer>());
        return result;
    }

    public void backTrack(int[] nums, List<Integer> item) {
        if(item.size() == nums.length) {
            result.add(new LinkedList<>(item));
            return;
        }
         for(int i = 0; i < nums.length; i++) {
            if(used[i] || (i > 0 && nums[i] == nums[i - 1]) && used[i - 1]) {
                continue;
            }
            item.add(nums[i]);
            used[i] = true;
            backTrack(nums, item);
            used[i] = false;
            item.remove(item.size() - 1);
        }
    }

}
