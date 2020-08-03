package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        System.out.println(fib(l));
    }

    /**
     * 斐波那契数列
     * 1，1，2，3，5，8，13...
     * 假设f(n) = n;
     * 则有 n = 0 或者 n = 1 时，f(n) = 1
     * 否则 f(n) = f(n-1) +  f(n-2)
     */
    public static long fib(long a) {
        if (a == 0 || a == 1) {
            return a;
        } else {
            return fib(a - 1) + fib(a - 2);
        }
    }

    /**
     * 找出字符串中出现次数最多的字符以及次数
     * 思路：
     * 将字符串分成n个子字符串，每个子字符串都是相同的字符，计算这些子字符串中最大的长度的值
     */
    @Test
    public void maxWord() {
        String str = "dafefasfadgafdfdkkdfasfeetvcbdfjyjkekweoopaaaa";
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(str.charAt(i));
        }
        ArrayList<StringBuilder> builderArrayList = new ArrayList<>();
        int max = 0;
        char ret = 0;
        while (!arrayList.isEmpty()) {
            char ch = arrayList.get(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (ch == arrayList.get(i)) {
                    sb.append(ch);
                    arrayList.remove(i);
                    i--;
                }
            }
            int size = sb.length();
            if (size > max) {
                max = size;
                ret = sb.charAt(0);
            }
            builderArrayList.add(sb);
        }
        System.out.println(builderArrayList);
        System.out.println(max);
        System.out.println(ret);
    }

    private final String[] mustNum = new String[]{"1", "2", "3", "4"};

    /**
     * 用1，2，2，3，4这五个数字，打印出所有不同的排列
     * 思路：
     * 这五个数字组成的数的大小范围是：12234~43221，通过遍历这些数字，找出符合要求的即可
     */
    @Test
    public void test1() {
        for (int i = 12234; i < 43221 + 1; i++) {
            if (isValidNum(String.valueOf(i))) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void sameString(){
        String[] strs = {"flower", "flag", "fluent"};
        int index = 0;


    }

    private boolean isValidNum(String str) {

        // 是否为都含有必要的数字
        for (String judge : mustNum) {
            if (!str.contains(judge)) {
                return false;
            }
        }

        // 是否含有两个2
        if (str.indexOf('2') == str.lastIndexOf('2')) {
            return false;
        }
        return true;
    }

    /**
     *
     */
    @Test
    public void test2() {
        int n = 2;
        int res = 1;
        while (getOnly(n) + res != n) {
            res += getOnly(n);
            n++;
        }
        System.out.println(n);
    }

    private int getOnly(int n) {
        String str = String.valueOf(n);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('1' == str.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 求素数
     */
    @Test
    public void test3() {
        int i, j, k = 0;
        for (i = 0; i < 101; i++) {
            if (!(i % 2 == 0 || i % 3 == 0 || i % 5 == 0)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 动态规划
     */
    @Test
    public void test4() {
        int[] nums = new int[]{4, 1, 1, 9, 1};
        int max = _test4(nums, nums.length - 1);
        System.out.println(max);
        max = _test41(nums);
        System.out.println(max);
    }

    private int _test4(int[] arr, int index) {
        if (index == 0) {
            return arr[0];
        } else if (index == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int A = _test4(arr, index - 2) + arr[index];
            int B = _test4(arr, index - 1);
            return Math.max(A, B);
        }
    }

    private int _test41(int[] arr) {
        int[] nums = new int[arr.length];
        nums[0] = arr[0];
        nums[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int A = nums[i - 2] + arr[i];
            int B = nums[i - 1];
            nums[i] = Math.max(A, B);
        }
        return nums[nums.length - 1];
    }

    @Test
    public void dp_test() {
        int n = 13;
        int[] dp = new int[n + 1];
        int[] tokens = {1, 5, 10, 25};
        int mod = 1000000007;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (tokens[i] == j) {               //硬币刚好等于当前面额
                    dp[j] = (dp[j] + 1) % mod;
                } else if (tokens[i] < j) {         //硬币小于当前面额
                    dp[j] = (dp[j] + dp[j - tokens[i]]) % mod;
                }                               //硬币大于当前面额，dp[j] = dp[j]，省略了
            }
        }
        System.out.println(dp[n]);
    }

    @Test
    public void objTest() {
        int i = 1 / -2;
        System.out.println(i);
        CTest cTest1 = new CTest("123");
        Object cTest2 = new CTest("123");
        System.out.println(cTest1.equals(cTest2));
    }

    @Test
    public void testCommonStrLength() {
        int commonStrLength = getCommonStrLength("baaabbabababbaabbaaaaaabbaabaabaaabbabbbbaabbaaabbbbbabababaaaaabbbbbabbbabaababaa", "bbbbbababbabaabbaabba");
        System.out.println(commonStrLength);
    }


    public static int getCommonStrLength(String str1, String str2) {
        int length = 0;
        for(int i = 0; i <= str1.length(); i++){
            for(int j = 0; j <= str1.length(); j++){
                if(i+j<= str1.length()){
                    String substring1 = str1.substring(j, i + j);
                    if (str2.contains(substring1) ){
                        length = Math.max(substring1.length(), length);
                    }
                }
            }
        }
        return length;
    }
}

class CTest {
    private String value = null;

    public CTest(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof CTest) {
            CTest test = (CTest) obj;
            return this.value.equals(test.value);
        }
        return false;
    }
}