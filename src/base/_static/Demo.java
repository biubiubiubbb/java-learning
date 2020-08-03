package base._static;

/*
成员函数可以使用静态变量和静态方法
静态函数不可以使用成员变量和成员方法
原因：
1.先有静态内容后有非静态内容
2.静态方法与this无任何关系

静态代码块：
当第一次用到本次是，会执行唯一的一次代码块
静态内容总是优先于非静态，先调用静态代码块在调用构造函数
 */

import org.junit.Test;

public class Demo {
    int num = 0; //成员变量
    static int i = 0;  // 静态变量，所有对象共享

    public static void main(String[] args) {
        Demo d = new Demo();
        Demo d1 = new Demo();
    }

    public Demo() {
        System.out.println("构造函数执行");
    }

    // 成员方法可以使用静态方法
    public void normalFunc() {
        staticFunc();
    }

    // 静态方法
    public static void staticFunc() {
        System.out.println("这是一个静态方法，所有类对象共享，可以不用new对象，用Demo.StaticFunc()来调用");
    }

    static {
        System.out.println("执行静态代码块");
    }
}
