package com.qinxi.learn.algorithm.hot100;

import org.junit.Test;

import java.util.*;

public class Demo {

    @Test
    public void test () {
        System.out.println(isValid("(([]){})"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1  < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        for(int i = 0 ; i < len - 1; i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == null) {
                return false;
            }
            if(!(s.charAt(i + 1) == map.get(ch) || s.charAt(len - i - 1) == map.get(ch))) {
                return false;
            }
            if(s.charAt(i + 1) == map.get(ch)) {
                i++;
            }
        }
        return true;
    }

    @Test
    public void testNest() {
        List<Integer> list = new ArrayList<>();
        System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }

    public int arrayNesting(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = i, cnt = 0;
            while (nums[cur] != -1) {
                cnt++;
                int c = cur;
                cur = nums[cur];
                nums[c] = -1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
