package base.arrayUtil;

import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {

    @Test
    public void main(){
        Integer[] array = {1, 3, 5, 2};
        Integer[] arrayCopy = {1, 3, 5, 2};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);  // 默认升序排序
        System.out.println(Arrays.toString(array));

        // 降序排序  使用Comparator<? super T> c函数接口实现   array必须为Integer[]引用型
        Arrays.sort(array, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(array));

        String[] strArray = {"bbb", "aaa", "ccc"};
        Arrays.sort(strArray);
        System.out.println(Arrays.toString(strArray));

        int ret = Arrays.compare(array, arrayCopy); // 相同返回0
        System.out.println(ret);
    }
}
