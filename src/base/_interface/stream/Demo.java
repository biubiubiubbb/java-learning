package base._interface.stream;

import java.util.List;
import java.util.stream.Stream;

/**
 * JDK1.8开始加入Stream流操作
 * 所有Collection集合都可以通过stream获取流或者通过Stream.of,数组也可以
 * Stream<Integer> s = Stream.of(1,2,3,4);
 * Integer[] arr = {1,2,3,4};
 * Stream<Integer> arrStream = Stream.of(arr);
 * 注意：流只能使用一次，使用后关闭，顾名思义流水线
 * 优点：可以一次性数据进行多次处理，不需要每次都要遍历数据，并且代码可以很简洁
 * <p>
 * 常用的流方法：
 * map映射，一个流转化为另一个流
 * sorted升序排序
 * count统计流中元素的个数
 * limit(n)取前n个流中的元素
 * skip则和limit相反，跳过n个元素，取后面的元素
 * Stream中的静态方法，contact连接两个流
 */
public class Demo {
    public static void main(String[] args) {
        streamTest();
    }

    public static void streamTest() {
        List<String> list = List.of("张三", "李四", "张三丰", "张麻子");
        Stream<String> stream = list.stream();
        stream
                .filter(name -> name.startsWith("张"))  // 过滤不为张的姓名 这里使用的就是Predicate数据判断接口
                .filter(name -> name.length() == 3)     // 过滤长度不为3的姓名
                .forEach(System.out::println);          //这里使用的就是Consumer数据判断接口
        // error:stream has already been operated upon or closed
        //stream.forEach(name-> System.out.println(name));

        Stream<String> strStream = Stream.of("1", "3", "2", "4", "5");
        Stream<Integer> intStream = strStream.map(Integer::parseInt);  // 方法引用
        intStream.sorted().limit(4).skip(1).forEach(System.out::println); // 先排序，再限制流中的个数为4，在跳过第1个元素
    }
}
