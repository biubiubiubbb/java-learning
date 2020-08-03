package base.reflection.annotation.simple;

/*
 *Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。
 *Java 语言中的类、方法、变量、参数和包等都可以被标注。和 Javadoc 不同，Java
 *标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字节码中。
 *Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。 当然它也支持自定义 Java 标注。
 *
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

@SimpleAnnotation(className = "base.reflection.annotation.simple.Counter", methodName = "add")
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // simpleAnnotation本质上是实现一个已经是实现SimpleAnnotation接口的类的对象
        SimpleAnnotation simpleAnnotation = Demo.class.getAnnotation(SimpleAnnotation.class);
        String className = simpleAnnotation.className();  // 获取类名
        String methodName = simpleAnnotation.methodName(); // 获取方法名
        Class cls = Class.forName(className);  // 获取字节码文件信息

        // 必须为add(Integer a, Integer b)  ？？?
        Method method = cls.getMethod(methodName, Integer.class, Integer.class); // 获取方法
        int ret = (int) method.invoke(cls.newInstance(), 1, 2); // 调用方法
        System.out.println("ret:" + ret);
    }
}
