package base.collection.set.hashset;

import java.util.HashSet;

/*
HashSet:
1.底层是一个哈希表结构，查询速度快
2.不能保证元素的排列顺序，顺序有可能发生变化。
3.元素值可以是null，也仅有一个null
4.另外它不是同步的，如果多个线程同时访问一个Set，只要有一个线程修改集合中的值，就必须进行同步处理，
  通常通过同步封装这个Set的对象 来完成同步，如果不存在这样的对象，可以使用Collections.synchronizedSet()方法完成。
  Set s = Collections.synchronizedSet(new HashSet(...));
5.默认初始容量（16）和负载因子（0.75）
应用场景：
数据库中唯一约束
 */

public class Demo {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        boolean addRet = hashSet.add(1); // true
        addRet = hashSet.add(1); // false
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(null);  // size依然+1
        int size = hashSet.size();
        System.out.println(hashSet);
        
        for (var value : hashSet) {
            System.out.println(value);
        }

        var isContain = hashSet.contains(2);
        var hashSetClone = hashSet.clone();  // 与hashSet地址不一样，但他们引用的数据集合一样
    }
}
