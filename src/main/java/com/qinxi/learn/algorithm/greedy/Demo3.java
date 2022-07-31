package com.qinxi.learn.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;

public class Demo3 {

    @Test
    public void test() {
        //[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]

        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{new int[]{7, 0}, new int[]{4, 4}, new int[]{7, 1}, new int[]{5, 0}, new int[]{6, 1}, new int[]{5, 2}})));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2)->{
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
         for(int i = 0; i < people.length; i++) {
             int height = people[i][0];
             int k = people[i][1];
             int j = i;
              while(k > 0 && j < people.length - 1) {
                  if(people[j + 1][0] > height) {
                      k--;
                  }
                  j++;
              }
         }
        return people;
    }

    private void swap(int[] a, int[] b) {
        int[] temp = new int[] {a[0], a[1]};
        a[0] = b[0];
        a[1] = b[1];
        b[0] = temp[0];
        b[1] = temp[1];
    }

}
