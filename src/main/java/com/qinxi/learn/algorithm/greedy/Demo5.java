package com.qinxi.learn.algorithm.greedy;

import org.junit.Test;

import java.util.*;

public class Demo5 {

    @Test
    public void test() {
        System.out.println("-1".length());
        System.out.println("0-1".length());
        LinkedList<int[]> res = new LinkedList<>();
        int[][] ints = res.toArray(new int[0][0]);
        Set<Integer> set = new HashSet<>();
        Integer[] s = set.toArray(new Integer[0]);

        System.out.println(partitionLabels("ababcbacabqw"));
    }

    @Test
    public void testValidSquare() {
        // p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
        System.out.println(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] arr = new int[][] {p1, p2, p3, p4};
        Arrays.sort(arr,(o1,o2)-> (o1[0] + o1[1]) >  (o2[0] + o2[1]) ? 1 : -1);
        long len = getPowLen(arr[0], arr[1]);
        for(int i = 1; i < arr.length - 1; i++) {
            if(len != getPowLen(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testUniquePathsWithObstacles () {
        System.out.println(uniquePathsWithObstacles(new int[][]{new int[]{0,0}, new int[]{0,1}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = 1;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i - 1][j] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if(obstacleGrid[i][j - 1] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private long getPowLen(int[] a, int[] b) {
        int x = Math.abs(a[0] - b[0]);
        int y = Math.abs(a[1] - b[1]);
        return x * x + y * y;
    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}
