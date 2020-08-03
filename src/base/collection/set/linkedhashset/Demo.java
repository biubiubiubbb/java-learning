package base.collection.set.linkedhashset;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 如果无排序要求可以选用HashSet；
 * 如果想取出元素的顺序和放入元素的顺序相同，那么可以选用LinkedHashSet。
 * 如果想插入、删除立即排序或者按照一定规则排序可以选用TreeSet
 */
public class Demo {
    @Test
    public void demo(){
        Set<Integer> linkedHashSet = new TreeSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(2);
        linkedHashSet.add(8);
        linkedHashSet.add(4);
        for(var val : linkedHashSet){
            System.out.println(val);
        }
    }
}
