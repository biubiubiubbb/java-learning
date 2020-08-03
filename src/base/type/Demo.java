package base.type;

/*
不能存放基本类型,必须使用基本类型对应的包装类(Java.lang)
           基本类型        包装类
           byte           Byte
           int            Integer
           short          Short
           double         Double
           float          Float
           long           Long
           char           Character
           boolean        Boolean
Java中的数值类型不存在无符号的，它们的取值范围是固定的，不会随着机器硬件环境或者操作系统的改变而改变。
在定义布尔类型的变量时，不要使用isSuccess这种形式，而要直接使用success！
尽量使用包装类型。
* */

public class Demo {
    public static void main(String[] args) {
        Integer _i = 10;  // Integer i=10 可以替代 Integer i = new Integer(10) 即自动装箱
        int b = _i;     // 自动拆箱

        int max_val = Integer.MAX_VALUE;  // 0x7fffffff  2的31次方-1
        int min_val = Integer.MIN_VALUE;  // 0x80000000  -2的31次方

        // max_val == min_val   true

        int val = 0;
        test(val);
        System.out.println(val); // 0

        boolean flag = true;
        Integer i = Integer.valueOf(0);
        int j = 1;
        int k = flag ? i.intValue() : j;
        System.out.println(k);

        // 当需要进行自动装箱时，如果数字在-128至127之间时，会直接使用缓存中的对象，而不是重新创建一个对象

        Integer integer1 = 3;
        Integer integer2 = 3;

        Integer integer = Integer.valueOf(4);

        if (integer1 == integer2)
            System.out.println("integer1 == integer2"); // yes
        else
            System.out.println("integer1 != integer2");

        Integer integer3 = 300;
        Integer integer4 = 300;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4"); // no
        else
            System.out.println("integer3 != integer4");
    }

    public static void test(int val) {
        val = 1;
    }
}
