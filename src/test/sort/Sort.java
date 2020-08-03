package test.sort;

import org.junit.Test;

import java.util.Arrays;

public class Sort<T> {
    public void swap(T a, T b) {
        T temp = a;
        a = b;
        b = temp;
    }

    /**
     * 冒泡排序：
     * 比如有10个数字，需比较10-1次，第n次需要比较10-1-n此两两比较，最大的放在数组最后面
     * 时间复杂度：
     * 最坏  O(n^2)
     * 最好  O(n)
     * 平均  O(n^2)
     */
    @Test
    public void maoPao() {
        int[] arr = {5, 3, 6, 2, 9, 5, 7, 4, 3, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序：
     * <p>
     * 无论哪种情况，时间复杂度都是O(n^2)
     */
    @Test
    public void select() {
        Integer[] arr = {0, 3, 6, 2, 9, 8, 0, 5, 4, 5, 7, 4, 3, 2};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 选出[i+1, length-1] 数组中最小的数的索引
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 二分查找
     */
    @Test
    public void erFen() {

    }

    @Test
    public void quick_sort() {
        int i = 4%6;

        int[] arr = {4, 14, 6, 9, 3, 7, 12, 7, 10, 3, 7, 8};
        quick_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quick_sort(int[] arr, int low, int high) {
        if (low < high) {
            // 小于基准值放左边，大于基准值放右边
            int mid = getMid(arr, low, high);
            System.out.println(Arrays.toString(arr));
            quick_sort(arr, low, mid - 1);
            quick_sort(arr, mid + 1, high);
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

    private int getMid2(int[] arr, int low, int high){
        int pivot = arr[low];
        while(low < high){
            while(arr[high] >= pivot && low < high){
                high--;
            }
            arr[low] = high;
            while(arr[low] <= pivot && low < high){
                low++;
            }
            arr[high] = low;
        }
        arr[low] = pivot;
        return low;
    }
}
