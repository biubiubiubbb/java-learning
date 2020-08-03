package base.exception;

/*
如果抛出的多个异常类，如果存在共同父类，throws共同异常父类即可
调用方调用声明抛出异常的函数时，必须对抛出的异常做处理
1. 要么在方法体后面再throws, 最后交给JVM做中断处理
2. 要么try...catch...

Exception: 编译期异常
RuntimeException: 运行期异常，一般不处理，交给JVM做中断处理
 */

import org.junit.Test;

public class Demo {
    public static void main(String[] args) throws NullPointerException, IndexOutOfBoundsException {
        int[] arr = {1, 3, 4};
        try {
            throwsTest(arr, 3);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();  // 打印异常的跟踪栈信息
        }
        try {
            throwsTest(null, 1);
        } catch (NullPointerException e) {
            e.printStackTrace();  // 打印异常的跟踪栈信息
        } finally {
            System.out.println("finally block run anyway");
        }
        System.out.println("after exception");  // 如果抛出的两个异常都被捕获，这句话也会执行
    }

    public static void throwsTest(int arr[], int index) throws NullPointerException, IndexOutOfBoundsException {
        if (arr == null) {
            throw new NullPointerException("null pointer");
        }
        if (index > arr.length - 1) {
            throw new IndexOutOfBoundsException("out of index");
        }
    }

}
