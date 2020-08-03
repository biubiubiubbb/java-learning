package base._interface.simple_interface;

/*
 接口可多继承
 */
public interface ImpInterface extends SubInterface1, SubInterface2 {
    public abstract void interfaceMethod();

    // 接口的成员变量即常量
    public static final int NUM_OF_INTERFACE = 0;  // 灰色代表可以省略，为常量，不可变

    // 默认方法
    public default void method() {
        System.out.println("ImpInterface default method called");
    }

    // 共有静态方法
    public static void publicStaticMethod() {
        System.out.println("ImpInterface static method called");
        privateStaticMethod();
    }

    // 私有静态方法
    private static void privateStaticMethod() {
        System.out.println("ImpInterface private static method called");
    }
}

