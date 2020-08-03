package base.reflection.reflect_frame;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射简单引用：
 * 通过修改配置文件reflection.properties使用不同方法
 */
public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        ClassLoader classLoader = Demo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("reflection.properties");
        properties.load(inputStream);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class cls = Class.forName(className);
        Method method = cls.getDeclaredMethod(methodName);
        method.setAccessible(true);
        //  newInstance()用@Deprecated(since="9")注解，表示java9之后不推荐使用，但仍然可以使用
        method.invoke(cls.newInstance());
    }
}
