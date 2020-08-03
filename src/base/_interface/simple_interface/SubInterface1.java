package base._interface.simple_interface;

/*
任何版本的Java，接口都能定义抽象方法
接口的抽象方法，修饰符最好是两个固定关键字，public abstract
接口使用步骤:
1. 不能直接new interface
2. 必须有一个”实现类“来实现所有抽象方法，用关键字implements
接口允许定义默认方法，public default
默认方法可通过实现类对象直接使用，也可以被实现类重写

Java9开始，允许接口定义私有方法，包括成员私有，静态私有
接口以public static final三个关键字修饰常量
public static final int num = 0;

接口无静态代码块static{}和构造函数

一个类的父类是唯一的(单继承),但接口可实现多个
 */

public interface SubInterface1 {
    public abstract void subInterfaceMethod2();

    public final int publicNum = 0;
}
