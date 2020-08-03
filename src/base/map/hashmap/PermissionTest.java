package base.map.hashmap;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

/*
extends AbstractMap<K,V>
implements Map<K,V>, Cloneable, Serializable
在JDC1.8之前，哈希表底层采用数组+链表实现，使用链表处理哈希冲突，同一hashCode的元素都存储在一个链表里，
但如果hashCode相等的元素较多时，通过key值查找的效率较低。于是在JDK1.8中，哈希表采用数组+链表+红黑树实现，
当链表长度超过8时，将链表转化为红黑树，这样减少了查找时间
 */

public class PermissionTest {
    public static void main(String[] args) {
        int dd = Integer.parseInt("dd");
    }

    @Test
    public void simpleMethod() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        var value1 = hashMap.get("key1"); // value1
        var value3 = hashMap.get("key3"); // null

        hashMap.put("key3", "value3");
//        for (var key : hashMap.keySet()) {
//            System.out.println(key);
//        }
//        for (var value : hashMap.values()) {
//            System.out.println(value);
//        }
//        hashMap.remove("key1");
        for (var kv : hashMap.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
    }

    @Test
    public void specialKey() {
        // 自定义的引用类型作为key，必须重写hashCode和equals

        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(new Student("jake", 18), "上海");
        hashMap.put(new Student("jim", 17), "北京");
        hashMap.put(new Student("tom", 17), "海亚");
        hashMap.put(new Student("tom", 17), "海亚");
        for (var kv : hashMap.entrySet()) {
            System.out.println(kv.getKey() + "----" + kv.getValue());
        }
    }

}
