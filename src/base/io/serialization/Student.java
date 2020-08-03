package base.io.serialization;

import java.io.Serializable;

public class Student implements Serializable {
    // 显示声明序列号，只要改序列号不发生改变，反序列化就能找到这个类，即使类结构已经发生改变
    private static final long serialVersionUID = 100L;
    private final String name;
    private final int age;

    public static String staticStr = "is a static string";
    public static int staticNum = 100;   // 不会被序列化，再次序列化是仍然是100
    public transient String transientStr = "is a transient string";  // 不会被序列化


    @Override
    public String toString() {
        return "姓名：" + this.name + "\n年龄：" + this.age + "\nstaticStr:" + staticStr + "\ntransientStr:" + transientStr + "\nstaticNum:" + staticNum;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
        staticNum++;  // 反序列时仍然为100
        staticStr = "static string change";  // 反序列时仍然为"is a static string"
        transientStr = "transient string change"; // 反序列化时为null
    }

}
