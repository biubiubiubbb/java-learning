package com.qinxi.learn.algorithm.backTracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Demo2 {
    private List<String> result = new LinkedList<>();

    private StringBuffer path = new StringBuffer();

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);
        return result;
    }

    public void backTracking(String s, int start, int num) {
        if(num > 4) {
            return;
        }
        if(num == 4) {
            result.add(path.toString());
            return ;
        }
        for(int i = start + 1; i < s.length(); i++) {
            if(s.charAt(i) == '0' || i - start > 3 || (i - start == 3 && Integer.parseInt(s.substring(start, i)) > 255)) {
                continue;
            }
            num++;
            String p;
            if(num == 4) {
                p = s.substring(start, i);
            } else {
                p = s.substring(start, i) + ",";
            }
            path.append(p);
            backTracking(s, i + 1, num);
            path.delete(path.length() - p.length(), s.length());
            num--;
        }
    }
}
