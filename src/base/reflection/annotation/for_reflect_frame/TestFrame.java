package base.reflection.annotation.for_reflect_frame;

import java.lang.reflect.Method;

/*
 *给类、方法、属性加注解相当于添加了一个标签
 * 注解结合反射编写一个简单的测试框架
 */
public class TestFrame {
    public static void main(String[] args) {
        Counter counter = new Counter();  // 创建一个待测试类的对象
        Class cls = Counter.class; // 获取字节码文件对象
        Method[] methods = cls.getMethods(); // 获取待测试类所有公共方法
        int bug = 0;
        for (var method : methods) {
            if (method.isAnnotationPresent(Check.class)) {  // 执行Check注解的方法
                try {
                    int ret = (int) method.invoke(counter, 4, 0);
                    System.out.println(ret);
                } catch (Exception e) {
                    bug++;
                    System.out.println("方法：" + method.getName() + "出现异常：");
                    System.out.println("异常类型：" + e.getCause().getClass().getName());
                    System.out.println("异常原因：" + e.getCause().getMessage());
                }
            }
        }
        System.out.println("一共有" + bug + "个bug");
    }
}
