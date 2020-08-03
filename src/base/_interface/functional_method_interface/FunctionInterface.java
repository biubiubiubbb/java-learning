package base._interface.functional_method_interface;

import org.junit.Test;

import java.util.function.Consumer;   // 数据消费接口
import java.util.function.Function;   // 数据映射接口
import java.util.function.Predicate;  // 数据判断接口
import java.util.function.Supplier;   // 数据获取接口

public class FunctionInterface {

    @Test
    public void consumerTest() {
        // 怎么消费由lambda具体实现
        consumer(8, (integer) -> System.out.println("integer:" + integer));

        consumer(8, (integer) -> System.out.println("integer*integer:" + integer * integer));
    }

    @Test
    public void supplierTest() {
        // 获取什么的结果由lambda具体实现
        int[] arr = {1, 3, 4, 5, 1, 4, 9};

        // 获取最大值
        int max = supplier(() -> {
            int maxNum = arr[0];
            for (int value : arr) {
                if (value >= maxNum) {
                    maxNum = value;
                }
            }
            return maxNum;
        });
        System.out.println("max number:" + max);

        // 获取最小值
        int min = supplier(() -> {
            int minNum = arr[0];
            for (int value : arr) {
                if (value <= minNum) {
                    minNum = value;
                }
            }
            return minNum;
        });
        System.out.println("min number:" + min);
    }

    @Test
    public void predicateTest() {
        boolean ret = predicate(8, num -> num > 5);
        System.out.println(ret);

        ret = predicate(8, num -> num < 5);
        System.out.println(ret);
    }

    @Test
    public void functionTest() {
        int num = 9;
        String res = function(num, (s) -> num + "");  // 整型数字转换为字符串形式的数字
        System.out.println(res);
    }

    // 消费数据接口
    public void consumer(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }

    // 获取数据接口
    public int supplier(Supplier<Integer> supplier) {
        return supplier.get();
    }

    // 判断数据接口
    public boolean predicate(int num, Predicate<Integer> predicate) {
        return predicate.test(num);
    }

    // 数据映射接口
    public String function(int num, Function<Integer, String> function) {
        return function.apply(num);
    }
}



