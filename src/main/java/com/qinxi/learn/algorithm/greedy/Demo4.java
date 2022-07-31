package com.qinxi.learn.algorithm.greedy;

import org.junit.Test;

public class Demo4 {


    @Test
    public void test() {
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        System.out.println(findMinArrowShots(new int[][]{new int[]{-2147483646,-2147483645}, new int[]{2147483646,2147483647}}));
    }

    public int findMinArrowShots(int[][] points) {
//        Integer.compare()
//        Arrays.sort(points, (o1, o2)->{
//            if(o1[0] == o2[1]) {
//                return o1[1] - o2[1];
//            } else {
//                return Integer.compare(o1[0])
//            }
//        });
        int res = 1;
        for(int i = 1; i < points.length; i++) {
            int[] prev = points[i - 1];
            while(i < points.length && points[i][0] <= prev[1]) {
                i++;
            }
            if(i < points.length) {
                res++;
            }
        }
        return res;
    }


}
