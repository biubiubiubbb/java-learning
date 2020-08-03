package base.map.hashtable;

/*
HashTable底层也是一个哈希表，是一个线程安全的集合，是单线程集合，速度慢
HashMap底层是一个哈希表，是一个线程不安全的集合，是多线程集合，速度快

HashMap集合可以存储null键和值
HashTable则不可以

HashTable和Vector一样，在jdk1.2版本之后被先进的集合(HashMap,ArrayList)取代了
HashTable的子类Properties依然活跃在历史舞台，
Properties是一个唯一和IO流相结合的集合
 */

import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

public class PermissionTest {

    @Test
    public void simpleMethod() {
        Map<String, String> map = Map.of("key1", "val1", "key2", "val2");
        Hashtable<String, String> hashtable = new Hashtable<>(map);
        for (var kv : hashtable.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
        try {
            hashtable.put(null, "can not a null key"); // 抛NullPointerException异常
            hashtable.put("key3", null); // 抛NullPointerException异常
        } catch (Exception e) {
            System.out.println("Get exception:" + e.getMessage());
        }
        System.out.println("after exception");
    }
}
