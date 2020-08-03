package test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Demo {
    @Test
    public void demo() throws UnsupportedEncodingException {

        // char 类型可以存储一个中文汉字，因为 Java 中使用的编码是 Unicode（不选择任何特定的编码，
        // 直接使用字符在字符集中的编号，这是统一的唯一方法），一个 char 类型占 2 个字节（16bit），所以放一个中文是没问题的。
        //补充：使用 Unicode 意味着字符在 JVM 内部和外部有不同的表现形式，在 JVM 内部都是 Unicode，当这个字符被从 JVM
        // 内部转移到外部时（例如存入文件系统中），需要进行编码转换。所以 Java 中有字节流和字符流，以及在字符流和字节流之间进行转换的转换流，如 InputStreamReader 和 OutputStreamReader.
        // Javac 编译可以对字符串常量直接相加的表达式进行优化，不必要等到运行期去进行加法运算处理，而是在编译时去掉其中的加号，
        // 直接将其编译成一个这些常量相连的结果。所以 String s=“a”+”b”+”c”+”d”;只生成一个对象.
        int test = new String("中").getBytes("Unicode").length; // 4
        int test2 = new String("中").getBytes(StandardCharsets.UTF_8).length; // 3
        int test3 = new String("中").getBytes("GBK").length; // 2
        String str1 = "123";
        String str2 = "123";

        int num = 2 << 3;  // 2 * 2^3   // n * 2^m    : n<<m

        char ch = '中';


        if (test == 3 && test2++ == 3) {
            System.out.println("ok");
        }
        String str = null;
        // str.length(); str并没有分配到内存，执行此语句会抛出NullPointerException异常
        // && 和 || 是逻辑运算符，如果第一个操作数可以确定表达式的值，那么不会执行第二个操作数str.length()
        // & 和 | 是位移运算符，两个表达式都会执行
        try {
            if ((str != null) && (str.length() > 0)) {
                System.out.println("2");
            }
        } catch (NullPointerException e) {
            System.out.println("Get exception:" + e.getMessage());
        }
    }


    @Test
    public void demo2() {
        String str = "aaaBBBaaA23";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), 0);
        }
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        for (var kv : map.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
    }

    @Test
    public void demo3() {
        System.out.println(demo3("abc", "ddc", 0));
    }

    public boolean demo3(String A, String B, int index) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        char aa = a[index];
        char bb = b[index];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == aa) {
                a[i] = bb;
            }
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            stringBuilder1.append(a[i]);
            stringBuilder2.append(b[i]);
        }
        A = stringBuilder1.toString();
        B = stringBuilder2.toString();
        if ((index == A.length() - 1)) {
            return A.trim().equals(B.trim());
        }
        index++;
        return demo3(A, B, index);
    }

    public boolean isBug(int version) {
        return false;
    }

    @Test
    public void demo4() {
        int left = 1;
        int right = 5;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBug(mid)) {
                right = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    @Test
    public void demo5() {
        System.out.println(f(10));
    }

    private int f(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * f(n - 1) + 2;
    }
}
