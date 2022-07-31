package com.qinxi.learn.algorithm.string;

import org.junit.Test;

public class Demo {

    @Test
    public void test () {
        System.out.println(reverseVowels("hello"));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(isLetter(s.charAt(left))) {
                left++;
                continue;
            }
            if(isLetter(s.charAt(right))) {
                right--;
                continue;
            }
            int ch1 =(int) s.charAt(left) <= 'Z' && s.charAt(left) > '9'? s.charAt(left) + 32 : s.charAt(left);
            int ch2 =(int) s.charAt(right) <= 'Z' && s.charAt(right) > '9'? s.charAt(right) + 32 : s.charAt(right);
            if(ch1 != ch2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    boolean isLetter(char ch) {
        return (ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9');
    }

    public String reverseVowels(String s) {
        char[] chars = new char[s.length()];
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(!isYunYing(s.charAt(left)) && !isYunYing(s.charAt(right))) {
                chars[left] = s.charAt(left);
                chars[right] = s.charAt(right);
                right--;
                left++;
            } else if(!isYunYing(s.charAt(left))) {
                chars[left] = s.charAt(left);
                left++;
            } else if(!isYunYing(s.charAt(right))) {
                chars[right] = s.charAt(right);
                right--;
            } else {
                chars[left] = s.charAt(right);
                chars[right] = s.charAt(left);
                right--;
                left++;
            }
        }
        if(left == right) {
            chars[left] = s.charAt(left);
        }
        return new String(chars);
    }

    private boolean isYunYing (char ch) {
        if(!((ch <= 'z' && ch >= 'a') ||(ch <= 'Z' && ch >= 'A'))) {
            return false;
        }
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
