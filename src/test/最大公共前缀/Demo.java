package test.最大公共前缀;

public class Demo {
    public static void main(String[] args) {
        String[] strs = {"flight", "floor", "flower"};
        String result = Solution.longestCommonPrefix(strs);
        System.out.println(result);
        int[] nums;
    }
}

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (String str : strs) {
            //表示必须从0开始包含
            while (str.indexOf(res) != 0) {
                //开始滑动
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
