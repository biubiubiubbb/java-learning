package com.qinxi.learn.algorithm.backTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Parindrome {

    @Test
    public void test() {
        StringBuffer sb = new StringBuffer();
        String str = "1231231asdfasdf23";
        sb.append("abcd");
        sb.append(str);
        sb.delete(sb.length() - str.length(), sb.length());
        System.out.println(sb);
        System.out.println(partition("aab"));
    }

    private List<List<String>> result = new LinkedList<>();
    private LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }


    public void backTracking(String s, int start) {
        if(start == s.length()) {
            result.add(new LinkedList<>(path));
        }

        for(int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if(isPalindrome(str)) {
                path.add(str);
                backTracking(s, i + 1);
                path.removeLast();
            }
        }

    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
