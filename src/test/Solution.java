package test;

import org.junit.Test;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}, {3, 6}};
        int[][] queue = reconstructQueue(people);
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            double input = scanner.nextDouble();
//            double output = getCubeRoot(input);
//            System.out.println("%.1f".formatted(output));
//        }
//        scanner.close();
//
        Integer[] temp = {4, 4, 6, 8, 2, 5, 8, 1};
        List<Integer> list = new LinkedList<>(Arrays.asList(temp));
        list.sort((o1, o2) -> o2 - o1);
        Arrays.sort(temp, (o1, o2) -> o2 - o1);  // 降序
        System.out.println(Arrays.toString(temp)); // [8, 8, 6, 5, 4, 4, 2, 1]
        System.out.println(list);
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 先按身高降序，身高如果相同，按k升序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(people);
    }

    // 使用二分查找算法
    public static double getCubeRoot(double input) {
        double min = 0;  // 最小值

        double max = input; // 最大值

        double mid = 0; // 中值

        // 注意，这里的精度要提高一点，否则某些测试用例无法通过
        while ((max - min) > 0.001) {
            mid = (max + min) / 2;
            if (mid * mid * mid > input) {
                max = mid;    // 结果过大的话，将最大值设为中值=
            } else if (mid * mid * mid < input) {
                min = mid;  // 结果过大的话，将最小值设为中值
            } else {
                return mid;
            }
        }
        return max;
    }


    // 206583kmzct4aeil19dopqrsvx7gjybhw
    // 206583kmzct4aeil19dopqrsvx7gjybhw
    @Test
    public void testCount() {
        System.out.println(fun("eee2234bbacccddd"));
    }

    public static String count(String str) {
        class Node {
            public final Integer size;
            public final Character ch;

            public Node(int size, Character ch) {
                this.size = size;
                this.ch = ch;
            }
        }

        char[] chars = str.toCharArray();
        List<Node> list = new LinkedList<>();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char ch : chars) {
            if (ch > 'a' && ch < 'z' || ch > 'A' && ch < 'Z' || ch > '0' && ch < '9' || ch == ' ') {
                if (hashMap.containsKey(ch)) {
                    hashMap.put(ch, hashMap.get(ch) + 1);
                } else {
                    hashMap.put(ch, 1);
                }
            } else {
                hashMap.put(ch, 1);
            }
        }
        for (var key : hashMap.keySet()) {
            list.add(new Node(hashMap.get(key), key));
        }
        list.sort((o1, o2) -> {
            if (o1.size.equals(o2.size)) {
                return o2.ch - o1.ch;
            }

            return o1.size - o2.size;
        });
        StringBuilder sb = new StringBuilder();
        for (var node : list) {
            sb.append(node.ch);
        }
        return sb.toString();
    }

    private static String fun(String str) {
        char[] chs = str.toCharArray();
        int[] num = new int[200];     //必须大于128
        for (char c : chs) {
            num[(int) c]++;
        }

        // max 个数最多的字符的个数
        int max = 0;
        for (int value : num) {
            if (max < value) {
                max = value;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (max != 0) {
            for (int i = 0; i < num.length; i++) {
                if (max == num[i]) {
                    sb.append((char) i);
                }
            }
            max--;
        }
        return sb.toString();
    }


    @Test
    public void bit() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        {
            int max = 0;
//            byte num = sc.nextByte();
            int num = 127;
            while (num != 0) {
                int bit = num & 1;
                sb.append(bit);
                num >>= 1;
            }
            System.out.println(sb);
            String[] strS = sb.toString().split("0");
            for (String str : strS) {
                if (str.length() > max) {
                    max = str.length();
                }
            }
            System.out.println(max);
        }
    }

    @Test
    public void sss() {
        String str = "sdfadf sds fa adfa";
        List<String> list = new LinkedList();
        String[] strS = str.split(" ");
        System.out.println(strS.length);
        for (String s : strS) {
            System.out.println(s);
        }
    }

    @Test
    public void maxSubArray() {
        int[] nums = {-1, 2, -1, -3, 4, 5};
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);;
        }

        System.out.println(Arrays.toString(dp));
    }

}