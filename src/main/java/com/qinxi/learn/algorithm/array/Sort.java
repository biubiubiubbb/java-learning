package com.qinxi.learn.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

public class Sort {



    @Test
    public void testQuickSort() {
        int[] nums = new int[] {4,5,2,7,3,7,9,8};
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 快排
     * 时间复杂度：
     * 1.最好: n * logN
     * 2.最坏：n * n
     * 3.平均: n * logN
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 小于基准值放左边，大于基准值放右边
            int mid = getMid(arr, low, high);
            System.out.println(Arrays.toString(arr));
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private int getMid(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (arr[high] >= pivot && low < high) {
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= pivot && low < high) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

}
