package test.删除排序数组中的重复元素;

/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
你不需要考虑数组中超出新长度后面的元素
 */

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int ret = Solution.removeDuplicates_2(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(ret);
    }
}

class Solution {
    // 数组重赋值法
    public static int removeDuplicates_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int lastNum = nums[nums.length - 1];
        for (int i = 0; i <= length - 1; i++) {
            i++;
            if (nums[i] == nums[i + 1]) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                if (nums[i] == lastNum) {
                    return i + 1;
                }
                i--;
            }
        }
        return 0;
    }

    // 双指针法 快指针j 慢指针i
    static public int removeDuplicates_2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
