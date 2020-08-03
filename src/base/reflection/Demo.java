package base.reflection;
/*
 *反射的定义：
 *JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 * 对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。
 *
 * 优点：
 *      1.可以在程序运行过程中操作对象(如IDEA的执行提示，原理所使用的就是反射机制)
 *      2.解耦，提高程序可扩展性(框架的设计也是基于反射)
 */

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo {
    /**
     * 不同阶段获取Class对象的方式：
     * 1.源码阶段：Class.forName(全类名)：将字节码文件加载进内存，返回Class对象
     * *多用于配置文件，将类名定义在配置文件中。通过读取文件去加载类
     * 2.Class类对象阶段：类名.class：通过类名属性class获取
     * *多用于参数传递
     * 3.运行时阶段：对象.getClass()：getClass()方法在Object类中定义了
     * *多用于对象的获取字节码的方法(废话)
     * 结论：
     * 同一个字节码文件(*.Class)在一次程序运行过程中，只会被加载一次，
     * 无论通过哪种方法获取的Class对象都是同一个
     */
    @Test
    public void getClassTest() throws Exception {
        Class cls1 = Class.forName("base.reflection.Student");
        Class<Student> cls2 = Student.class;
        Class cls3 = new Student("小华").getClass();

        System.out.println(cls1 == cls2 && cls1 == cls3); // true

        System.out.println(cls1.getName());
        System.out.println(Arrays.toString(cls1.getFields()));
        System.out.println(Arrays.toString(cls1.getMethods()));
    }

    /**
     * 使用Class对象获取属性、成员方法、构造方法
     * 获取属性: getFields()  /  getDeclaredFields()
     * 获取成员方法: getMethods  /   getDeclaredMethods()
     * 获取构造器： getConstructors /  getDeclaredConstructors()
     */
    @Test
    public void useClassTest() throws Exception {
        Class cls = Class.forName("base.reflection.Student");
        Student stu = new Student("Java");
        System.out.println("stu's name is " + stu.getName() + " before");
        System.out.println("-------------------get student's class public fields-------------------");
        for (var publicField : cls.getFields()) {
            ; // 获取所有公有属性
            System.out.println(publicField);
        }
        System.out.println("-------------------get student's class all fields-------------------");
        for (var field : cls.getDeclaredFields()) {
            ; // 获取所有属性
            System.out.println(field);
            if (field.getName().equals(cls.getDeclaredField("name").getName())) {
                field.setAccessible(true); // 暴力反射
                field.set(stu, "C++"); // 修改了私有属性name的值,即使它是final修饰的
            }
        }
        System.out.println("stu's name is " + stu.getName() + " after");

        Method method = cls.getDeclaredMethod("simpleMethod", String.class);
        method.setAccessible(true); // 方法为私有时需设置
        method.invoke(stu, "hello world");  // 调用stu.simpleMethod()

        System.out.println("-------------------get student's class all constructors-------------------");
        for (var constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }

    }


}
