package base.map.linkedhashmap;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/*
extends HashMap<K,V>
implements Map<K,V>

底层结构：哈希表+链表(记录元素的顺序)
特点：不允许key重复，有序，允许null，此实现不是同步的
 */

public class Demo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key1", "value1");
        linkedHashMap.put("key2", "value2");
        linkedHashMap.put("key3", "value3");
        linkedHashMap.put(null, "value3");
        for (var kv : linkedHashMap.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
    }
}
