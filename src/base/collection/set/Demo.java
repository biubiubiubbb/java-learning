package base.collection.set;

import java.util.*;

/*
LinkedHashSet:
1.底层结构是由哈希表(数组+链表+红黑树)+链表组成，第二个链表保证了元素的有序性
2.此实现不是同步的
 */


public class Demo {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("aaa");
        linkedHashSet.add("bbb");
        linkedHashSet.add("ccc");
        System.out.println(linkedHashSet); // [aaa, bbb, ccc]
        linkedHashSet.clear();
        linkedHashSet.add("ccc");
        linkedHashSet.add("bbb");
        linkedHashSet.add("aaa");
        linkedHashSet.add(null); // 允许插入null
        System.out.println(linkedHashSet); // [ccc, bbb, aaa]  有序不允许元素重复

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("aaa");
        hashSet.add("bbb");
        hashSet.add("ccc");
        System.out.println(hashSet); // [aaa, ccc, bbb]
        hashSet.clear();
        hashSet.add("ccc");
        hashSet.add("bbb");
        hashSet.add("aaa");
        System.out.println(hashSet); //[aaa, ccc, bbb]  无序不允许元素重复

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(10);
            System.out.println(num);
            set1.add(num);
            set2.add(num);
        }
        System.out.println(set1);
        System.out.println(set2);
    }
}
