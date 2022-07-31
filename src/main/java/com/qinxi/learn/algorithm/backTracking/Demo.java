package com.qinxi.learn.algorithm.backTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Demo {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, new LinkedList<Integer>());
        return result;
    }

    private void backTracking(int n, int k, LinkedList<Integer> list) {
        if(list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        for(int num = n; num >= 1; num--) {
            list.add(num);
            backTracking(num - 1, k, list);
            list.pollLast();
        }
    }

    @Test
    public void test() {
        System.out.println("123".substring(0, 3));
        System.out.println("123".substring(1,2));
        System.out.println(combinationSum2(new int[] {2,5,2,1,2}, 5));
    }



    private List<List<Integer>> reuslt = new LinkedList<>();
    private boolean[] flags;
    private int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        flags = new boolean[candidates.length];
        backTracking(candidates, target, sum, 0, new LinkedList<Integer>());
        return reuslt;
    }

    public void backTracking(int[] candidates, int target, int sum, int index, LinkedList<Integer> list) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            List<Integer> temp = new LinkedList<>();
            for(int i : list) {
                temp.add(candidates[i]);
                flags[i] = true;
            }
            reuslt.add(temp);
            return;
        }
        for(int i = index; i < candidates.length && !flags[i]; i++) {
            sum += candidates[i];
            list.add(i);
            backTracking(candidates, target, sum, index + 1, list);
            list.pollLast();
            sum -= candidates[i];
        }
    }



}
