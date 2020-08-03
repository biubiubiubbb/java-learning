package base.string;

/*
 * 对于基本类型来说，==是数值的比较
 * 对于引用类型来说，==是地址的比较
 * 双引号写的字符串都存储在字符串常量区（堆的一种）, new的字符串在非字符串常量区
 * 1.一旦一个string对象在内存(堆)中被创建出来，他就无法被修改。
 * 特别要注意的是，String类的所有方法都没有改变字符串本身的值，都是返回了一个新的对象。
 * 2.如果你需要一个可修改的字符串，应该使用StringBuffer 或者 StringBuilder。
 * 否则会有大量时间浪费在垃圾回收上，因为每次试图修改都有新的string对象被创建出来
 *
 * 线程安全性
 * String 中的对象是不可变的，也就可以理解为常量，线程安全。
 * StringBuffer 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。
 * StringBuilder 并没有对方法进行加同步锁，所以是非线程安全的。
 *
 * 性能
 * 每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象。
 * StringBuffer 每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象引用。
 * 相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。
 *
 * 操作少量的数据: 适用 String
 * 单线程操作字符串缓冲区下操作大量数据: 适用 StringBuilder
 * 多线程操作字符串缓冲区下操作大量数据: 适用 StringBuffer
 */

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        String str1 = "abc";  // 存放于字符串常量区
        System.out.println("str1 hashCode:" + str1.hashCode());
        String str2 = "abc";
        char[] charArray = {'a', 'b', 'c'};
        String newStr = new String(charArray);
        System.out.println(str1 == str2); // true
        System.out.println(str1 == newStr); // false

        str1 = "ABC";  // str1的地址已经改变，abc内容不会变
        System.out.println("str1 hashCode:" + str1.hashCode());

        String str3 = "123";
        String referStr3 = str3;  // referStr3和str3指向"123"的地址，此时referStr3和str3地址值相同
        referStr3 = "456"; // 字符常量无法修改，实际是重新new了一块空间存储"456"，此时refer_str3和str3地址值此时不同
        System.out.println(str3);

        StringBuilder sb = new StringBuilder("string builder");
        sb.append('d').append(1).append(true).append("str");  // 不会new新的空间
        String sbStr = sb.toString();  //string builderd1truestr
        System.out.println(sbStr);

        // String methods
        String test = "234,treads";
        System.out.println(test.charAt(0));
        System.out.println(test.concat("---1234"));
        System.out.println(Arrays.toString(test.split(",")));  //分割
        System.out.println(test.substring(1, 4));
        System.out.println(test.indexOf("3"));  // 未找到返回-1
        System.out.println(test.length());

        System.out.println("%dfjaif%s".formatted(2, "fdf"));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
    }
}
