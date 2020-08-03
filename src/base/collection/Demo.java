package base.collection;

import java.util.*;

/*
Collection 是一个集合接口。 它提供了对集合对象进行基本操作的通用接口方法。
Collection接口在Java 类库中有很多具体的实现。是list，set等的父接口。
Collections 是一个包装类。 它包含有各种有关集合操作的静态多态方法。
此类不能实例化，就像一个工具类，服务于Java的Collection框架。
日常开发中，不仅要了解Java中的Collection及其子类的用法，还要了解Collections用法。
可以提升很多处理集合类的效率。
 */
/*
LinkedList、ArrayList、HashSet是非线程安全的，Vector是线程安全的;
HashMap是非线程安全的，HashTable是线程安全的;
StringBuilder是非线程安全的，StringBuffer是线程安全的。
 */
/*
Collection function:
add
remove
removeAll
clear
size
contains
isEmpty
 */

public class Demo {

    public static void main(String[] args) {
        Collection<Integer> treeSet = new TreeSet<>();
//        Collection<Integer> hashSet = new HashSet<>();
//        Collection<Integer> linkedHashSet = new LinkedHashSet<>();
//
//        Collection<Integer> vector = new Vector<>();
//        Collection<Integer> linkedList = new LinkedList<>();

        Collection<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        Collection<Integer> listTemp = new ArrayList<>();
        listTemp.add(1);
        listTemp.add(2);
        listTemp.add(3);

        list.addAll(listTemp);
        System.out.println(list); // [8,6,1,2,3]
        for (Integer num : list) {
            System.out.println(num);
        }

        boolean bRet1 = list.contains(5); // false
        boolean bRet2 = list.contains(8); // true

        list.remove(6);
        System.out.println(list); // [8,1,2,3]

        list.removeAll(listTemp);
        System.out.println(list); // [8]

        list.clear();  // []
        Object obj;
    }
}
