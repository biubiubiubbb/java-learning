package base._interface.simple_method_interface;

/*
只有一个抽象方法的接口称为函数式接口，当然接口中可以包含其他方法(默认、静态、私有)
 */

import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Demo {
    @Test
    public void main() throws InterruptedException {
        useInterfaceMethod(new SimpleMethodInterfaceImp());  // 使用函数接口的实现类
        useInterfaceMethod(new SimpleMethodInterface() {    // 本质上和上面一样，只不过是一个匿名类
            @Override
            public void method() {
                System.out.println("use anonymous inner class to say hello world");
            }
        });

        useInterfaceMethod(() -> {
            System.out.println("use lambda to say hello world");  // 用Lambda
        });
    }

    public static void useInterfaceMethod(SimpleMethodInterface simpleMethodInterface) throws InterruptedException {
        simpleMethodInterface.method();
    }
}

class SimpleMethodInterfaceImp implements SimpleMethodInterface {
    @Override
    public void method() {
        System.out.println("use implement class to say hello world");
    }
}

/**
 * @FunctionalInterface 该注解表示接口Functional是否为函数式接口
 * 是则编译通过，否则不通过
 */
@FunctionalInterface
interface SimpleMethodInterface {
    public abstract void method() throws InterruptedException;
}


